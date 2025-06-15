# CLI Utilities for interacting with the API

```
To use me, run this first:
Note: Notice the two dots, this means source the script
. .\test-client.ps1

Available functions:

Get-PizzaMenuEntry
Add-PizzaMenuEntry -Name <name> -Description <description> -Price <price>
Remove-PizzaMenuEntry -ItemId <id>

Get-PizzaOrder
Add-PizzaOrderItem -OrderId <order id> -ItemId <item id>
Remove-PizzaOrderItem -OrderId <order id> -ItemId <item id>
```