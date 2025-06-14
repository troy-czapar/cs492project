$Url="http://localhost:8080/v1"
$MenuUrl="$Url/Menu/"
$OrdersUrl="$Url/Orders/"
$UsersUrl="$Url/Users/"

$UsersList=@()
$UsersList+=@{displayName='Luis';email="luis@gmail.com";password='123456';role="customer"}
$UsersList+=@{displayName='Troy';email="troy@gmail.com";password='123456';role="customer"}
$UsersList+=@{displayName='Luis';email="Zach@gmail.com";password='123456';role="manager"}

$MenuList=@()
$MenuList+=@{name='Margherita Pizza';description='Classic Margherita Pizza with fresh basil';price=14;image='/images/margherita.png';quantity=0}
$MenuList+=@{name='Cheese Pizza';description='All Cheese pizza';price=12;image='/images/cheese.png';quantity=0}
$MenuList+=@{name='Meatlovers Pizza';description='4 Meats pizza: Pepperoni, Sausage, Meatballs, bacon';price=17;image='/images/meatlovers.png';quantity=0}
$MenuList+=@{name='Vegetarian Pizza';description='4 Vegetables pizza: Banana Peppers, olives, tomatoes, basil';price=14;image='/images/veggie.png';quantity=0}

# Add users
$UsersList | ForEach-Object {
    try {
        #Write-host "Adding a user to the Users API at $UsersUrl"
        $UserEntry=[PsCustomObject]@{
            displayName=$_.displayName
            email=$_.email
            password=$_.password
            role=$_.role
        }
        $UserEntryPayload = $UserEntry | ConvertTo-Json
        $result=Invoke-RestMethod -Uri $UsersUrl -Method Post -Body $UserEntryPayload  -ContentType 'application/json'
        # create their order
        $hide=Invoke-RestMethod -Uri "$OrdersUrl$($result.id)" -Method Post

    } catch {
        Write-Host "Problem adding user: $($_.Exception.Message)"
    }
}

# Add menu items
$MenuList | ForEach-Object {
    try {
        #Write-host "Adding a menu item to the Menu API at $MenuUrl"
        $MenuEntry=[PsCustomObject]@{
            name=$_.name
            description=$_.description
            price=$_.price
            image=$_.image
            quantity=$_.quantity
        }
        $MenuEntryPayload = $MenuEntry | ConvertTo-Json

        $hide=Invoke-RestMethod -Uri $MenuUrl -Method Post -Body $MenuEntryPayload  -ContentType 'application/json'
    } catch {
        Write-Host "Problem adding menu item: $($_.Exception.Message)"
    }
}

# Add items to orders
$OrdersList=@()
$OrdersList+=@{userId=1;menuItemId=1}
$OrdersList+=@{userId=1;menuItemId=2}
$OrdersList+=@{userId=1;menuItemId=2}
$OrdersList+=@{userId=2;menuItemId=3}
$OrdersList+=@{userId=2;menuItemId=4}

$OrdersList | ForEach-Object {
    try {
        #Write-host "Adding an order to the Orders API at $OrdersUrl"
        $AddItemToOrderUrl="$OrdersUrl$($_.userId)/add/$($_.menuItemId)"
        $hide=Invoke-RestMethod -Uri $AddItemToOrderUrl -Method Post
    } catch {
        Write-Host "Problem adding order: $($_.Exception.Message)"
    }
}


# Retrieve users
try {
    Write-warning "Users"
    Invoke-RestMethod -Uri $UsersUrl -Method Get | ft
    
} catch {
    Write-Host "Problem retrieving users: $($_.Exception.Message)" | ft
}
# Retrieve menu items

try {
    Write-warning "Menu Items"
    Invoke-RestMethod -Uri $MenuUrl -Method Get | ft
    
} catch {
    Write-Host "Problem retrieving menu items: $($_.Exception.Message)"
}

# Retrieve orders
try {
    Write-warning "Orders"
    Invoke-RestMethod -Uri $OrdersUrl -Method Get | ft
    
} catch {
    Write-Host "Problem retrieving orders: $($_.Exception.Message)"
}
