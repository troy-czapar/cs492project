package com.cs492.backend.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// This class represents a menu entry in the pizza ordering system.

@Entity
public class MenuEntries {

    // Unique identifier for the menu entry
    @Id
    // Use auto-generated value for ID
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    
    private String name;
    private String description;
    private Long price=0L; // Default price is 0
    private String image;
    private Integer quantity;

    // Getters and Setters
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;        
    }

    // Name
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;        
    }
    
    // Description
    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;        
    }

    // Price
    public Long getPrice(){
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;        
    }

    // Image URL    
    public String getImage(){
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;        
    }

    // Quantity
    public Integer getQuantity(){
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;        
    }

}
