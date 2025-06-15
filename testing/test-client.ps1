$Url="http://localhost:8080/pizza"
$MenuUrl="$Url/menu/"
$OrdersUrl="$Url/orders/"
$UsersUrl="$Url/users/"

function Get-PizzaMenuEntry() {
    Invoke-RestMethod -Uri $MenuUrl -Method Get 
}
function Add-PizzaMenuEntry($Name, $Description, $Price) {

    Write-host "Adding a menu item to the Menu API at $MenuUrl"
    $MenuEntry=[PsCustomObject]@{
        name=$Name
        description=$Description
        price=$Price
        image="/images/$($Name).png"
        quantity=0
    }
    $MenuEntryPayload = $MenuEntry | ConvertTo-Json

    Invoke-RestMethod -Uri $MenuUrl -Method Post -Body $MenuEntryPayload  -ContentType 'application/json'

}
function Remove-PizzaMenuEntry($ItemId) {
    #Write-warning "Not implemented yet"
     Write-host "Removing a menu item from the Menu API at $MenuUrl"
     $RemoveUrl="$MenuUrl$ItemId"
     Invoke-RestMethod -Uri $RemoveUrl -Method Delete
}
function Get-PizzaOrder() {
        Invoke-RestMethod -Uri $OrdersUrl -Method Get 
}
function Add-PizzaOrderItem($OrderId,$ItemId) {
    Write-host "Adding an order item to the Orders API at $OrdersUrl"
    $OrderAddUrl="$OrdersUrl$($OrderId)/add/$($ItemId)"
    Invoke-RestMethod -Uri $OrderAddUrl -Method Post 
}
function Remove-PizzaOrderItem($OrderId,$ItemId) {
    Write-host "Removing an order item from the Orders API at $OrdersUrl"
    $OrderRemoveUrl="$OrdersUrl$($OrderId)/remove/$($ItemId)"
    Invoke-RestMethod -Uri $OrderRemoveUrl -Method Post 
}

Write-host "To use me, run this first:"
Write-host "Note: Notice the two dots, this means source the script"
Write-host ". .\test-client.ps1"
write-host ""
write-host "Available functions:"
Write-host "Get-PizzaMenuEntry"
Write-host "Add-PizzaMenuEntry -Name <name> -Description <description> -Price <price>"
Write-host "Get-PizzaOrder"
Write-host "Add-PizzaOrderItem -OrderId <order id> -ItemId <item id>"
Write-host "Remove-PizzaOrderItem -OrderId <order id> -ItemId <item id>"
write-host ""