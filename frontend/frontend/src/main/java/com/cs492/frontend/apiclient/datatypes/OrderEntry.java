package com.cs492.frontend.apiclient.datatypes;

import java.io.Serializable;
import java.util.ArrayList;

// This data type represents an order entry in the restaurant application.

public class OrderEntry implements Serializable {

    private Long id;
    private ArrayList<Long> items = new ArrayList<>();
    private Long totalPrice; 
    private String status;

    public OrderEntry() {
        // Default constructor
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ArrayList<Long> getItems() {
        return items;
    }
    public void setItems(ArrayList<Long> items) {
        this.items = items;
    }
    public Long getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
