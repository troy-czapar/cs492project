$Url="http://localhost:8080/v1"
$MenuUrl="$Url/Menu/"
$OrdersUrl="$Url/Orders/"
$UsersUrl="$Url/Users/"

# Try User API
try {
    Write-host "Adding a user to the Users API at $UsersUrl"
    $UserEntry=[PsCustomObject]@{
        displayName='Pedro'
        email="Pedro@gmail.com"
        password='123456'
        role="customer"
    }
    $UserEntryPayload = $UserEntry | ConvertTo-Json
    $AddUserOp=Invoke-RestMethod -Uri $UsersUrl -Method Post -Body $UserEntryPayload  -ContentType 'application/json'
} catch {
    Write-Host "Problem adding user: $($_.Exception.Message)"
}

try {
    $UserItems=Invoke-RestMethod -Uri $UsersUrl -Method Get
    #$UserItems
} catch {
    Write-Host "Problem retrieving users: $($_.Exception.Message)"
}

# Try Menu API

try {
    Write-host "Adding a menu item to the Menu API at $MenuUrl"
    $MenuEntry=[PsCustomObject]@{
        name='Margherita Pizza'
        description='Classic Margherita Pizza with fresh basil'
        price=14.99
        image='/images/margherita.png'
        quantity=0
    }
    $MenuEntryPayload = $MenuEntry | ConvertTo-Json

    $AddMenuItemOp=Invoke-RestMethod -Uri $MenuUrl -Method Post -Body $MenuEntryPayload  -ContentType 'application/json'

} catch {
    Write-Host "Problem adding menu item: $($_.Exception.Message)"
}

try {
    $MenuItems=Invoke-RestMethod -Uri $MenuUrl -Method Get 
    #$MenuItems
} catch {
    Write-Host "Problem retrieving menu items: $($_.Exception.Message)"
}

# Try Orders API

try {
    Write-host "Adding an order to the Orders API at $OrdersUrl"
    # Create a new order for the created user
    $OrderItems=Invoke-RestMethod -Uri "$OrdersUrl$($UserItems[0].id)" -Method Post
} catch {
    Write-Host "Problem adding order: $($_.Exception.Message)"
}
try {
    $OrderAddUrl="$OrdersUrl$($OrderItems[0].id)/add/$($MenuItems[0].id)"
    #$OrderAddUrl

    #$OrderEntryPayload = $MenuItems[0] | ConvertTo-Json
    #$OrderEntryPayload 
    Write-Host "Adding order item using $OrderAddUrl"
    $AddOrderItemOp=Invoke-RestMethod -Uri $OrderAddUrl -Method Post 
    $AddOrderItemOp=Invoke-RestMethod -Uri $OrderAddUrl -Method Post 
    $AddOrderItemOp=Invoke-RestMethod -Uri $OrderAddUrl -Method Post 


    #$OrderEntryPayload = $MenuItems[3] | ConvertTo-Json
    #Invoke-RestMethod -Uri $OrderAddUrl -Method Post -Body $OrderEntryPayload  -ContentType 'application/json'
} catch {
    Write-Host "Problem adding order item: $($_.Exception.Message)"
}


try {
    $OrderRemoveUrl="$OrdersUrl$($OrderItems[0].id)/remove/$($MenuItems[0].id)"


    #$OrderEntryPayload = $MenuItems[0] | ConvertTo-Json
    #$OrderEntryPayload 
    Write-Host "removing order item using $OrderRemoveUrl"
    $RemoveOrderItemOp=Invoke-RestMethod -Uri $OrderRemoveUrl -Method Post 



    #$OrderEntryPayload = $MenuItems[3] | ConvertTo-Json
    #Invoke-RestMethod -Uri $OrderAddUrl -Method Post -Body $OrderEntryPayload  -ContentType 'application/json'
} catch {
    Write-Host "Problem removing order item: $($_.Exception.Message)"
}

try {
    $OrderItems=Invoke-RestMethod -Uri $OrdersUrl -Method Get
    #$OrderItems
} catch {
    Write-Host "Problem retrieving order items: $($_.Exception.Message)"
}
$OrderItems

#>
