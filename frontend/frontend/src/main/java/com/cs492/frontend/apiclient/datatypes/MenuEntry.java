package com.cs492.frontend.apiclient.datatypes;

import java.io.Serializable;

// This data type represents a menu entry in the restaurant application.

public class MenuEntry implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Long price;



    public MenuEntry() {
        // Default constructor
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    
}
