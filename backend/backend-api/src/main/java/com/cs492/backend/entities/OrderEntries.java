package com.cs492.backend.entities;

import java.util.ArrayList;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

// This class represents an order entry in the pizza ordering system.

@Entity
public class OrderEntries {

    // Unique identifier for the order entry
    @Id
    private Long id;
    private ArrayList<Long> items = new ArrayList<>();
    private Long totalPrice=0L; // Default total price is 0
    private String status = OrderStatus.PENDING; // Default status is PENDING


    // Getters and Setters
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;        
    }

    // Total Price - which is always updated during add/remove item
    public Long getTotalPrice(){
        return totalPrice;
    }

    // This method returns the list of items in the order
    public ArrayList<Long> getItems(){
        if (items == null) {
            items = new ArrayList<>();
        }

        return items;
    }

    // This method adds an item to the order and updates the total price
    public void addItem(Long item,Long price){

        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        if (this.totalPrice == null) {
            this.totalPrice = 0L;
        }

        if (item == null || price == null) {
            System.out.println("Item or price cannot be null.");
            return;
        }
        
        this.totalPrice += price;        
        this.items.add(item);        
    }

    // This method removes an item from the order and updates the total price
    public void removeItem(Long item,Long price){

        if (this.items.size() == 0) {
            System.out.println("No items to remove.");
            return;
        }
        if (!this.items.contains(item)) {
            System.out.println("Item not found in the order.");
            return;
        }
        this.totalPrice -= price;
        this.items.remove(item);
    }

    // Order Status
    public String getStatus(){
        return status;
    }
    
    public void setStatusComplete(Integer status) {
        this.status = OrderStatus.COMPLETED;        
    }

    public void setStatusPending(Integer status) {
        this.status = OrderStatus.PENDING;        
    }

    public void setStatusCanceled(Integer status) {
        this.status = OrderStatus.CANCELED;        
    }


}



