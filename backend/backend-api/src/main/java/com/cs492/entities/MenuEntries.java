package com.cs492.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class MenuEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    
    private String name;
    private String description;
    private Long price=0L; // Default price is 0
    private String image;
    private Integer quantity;

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;        
    }



    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;        
    }

    
    
    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;        
    }

    
    
    public Long getPrice(){
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;        
    }

    
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;        
    }

    public Integer getQuantity(){
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;        
    }


}
