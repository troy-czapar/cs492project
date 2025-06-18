package com.cs492.backend.controllers;

import java.util.Optional;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs492.backend.entities.MenuEntries;
import com.cs492.backend.entities.OrderEntries;
import com.cs492.backend.repositories.MenuStorage;
import com.cs492.backend.repositories.OrderStorage;

// This API controller handles order-related operations.

@RestController
@RequestMapping("/pizza/orders")
public class Orders {

    // Define variables to access the database
    private final OrderStorage orders;
    private final MenuStorage menu;

    // Default Constructor
    public Orders(OrderStorage orders,MenuStorage menu) {
        this.orders = orders;
        this.menu = menu;
    }

    // Get orders by ID
    @GetMapping("/{id}")
    public Optional<OrderEntries> getOrderEntry(@PathVariable("id") Long id) {
        // Check if the order with the specified ID exists
        // and if not, this means a new user/cart, create it!
        if (!orders.existsById(id)) {
            System.out.println("Order with ID " + id + " does not exist. Creating it!");
                OrderEntries newOrderEntry = new OrderEntries();
                newOrderEntry.setId(id);
                orders.save(newOrderEntry);                
        }
        return orders.findById(id);
    }

    // Get all orders
    @GetMapping("/")
    public Iterable<OrderEntries> getOrders() {
        return orders.findAll();
    }

    // Start a new order for the specified ID
    @PostMapping("/{id}")
    public OrderEntries createEmptyOrder(@PathVariable("id") Long id) {

        // Check if the order with the specified ID already exists
        Optional<OrderEntries> existingOrder = orders.findById(id);
        if (existingOrder.isPresent()) {
            System.out.println("Order with ID " + id + " already exists. Returning existing order.");
            return existingOrder.get();
        }

        OrderEntries newOrderEntry = new OrderEntries();
        newOrderEntry.setId(id);
        orders.save(newOrderEntry);
        return newOrderEntry;
    }


    // Add Menu item to order
    @PostMapping("/{id}/add/{itemId}")
    public Optional<OrderEntries> addItemToOrder(@PathVariable("id") Long id,@PathVariable("itemId") Long itemId) {
    
        final Optional<OrderEntries> currentOrder;
        final Optional<MenuEntries> menuItem = menu.findById(itemId);
        final Long itemPrice;

        if (menuItem.isPresent()) {
            itemPrice = menuItem.get().getPrice();
        } else {
            System.out.println("Menu item with ID " + itemId + " does not exist.");
            return Optional.empty(); // Return empty if item does not exist
        }

        currentOrder=orders.findById(id);
        currentOrder.ifPresent(value -> {
            System.out.println("Adding item to order: " + value.getId() + " Item: " + itemId + " Price: " + itemPrice);
            
            value.addItem(itemId,itemPrice);
            orders.save(value);
        });
            
        return orders.findById(id);
    }

    // Remove Menu item to order
    @PostMapping("/{id}/remove/{itemId}")
    public Optional<OrderEntries> removeItemToOrder(@PathVariable("id") Long id,@PathVariable("itemId") Long itemId) {


        final Optional<OrderEntries> currentOrder;
        final Optional<MenuEntries> menuItem = menu.findById(itemId);
        final Long itemPrice;
        if (menuItem.isPresent()) {
            itemPrice = menuItem.get().getPrice();
        } else {
            System.out.println("Menu item with ID " + itemId + " does not exist.");
            return Optional.empty(); // Return empty if item does not exist
        }

        
        currentOrder=orders.findById(id);
        currentOrder.ifPresent(value -> {
            System.out.println("Removing item to order: " + value.getId() + " Item: " + itemId);

            value.removeItem(itemId,itemPrice);
            orders.save(value);
        });

        return orders.findById(id);
    }

}
