package com.cs492.backend.entities;


import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// This class represents a user entry in the pizza ordering system.

@Entity
public class UserEntries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String displayName;
    private String email;
    private String role;
    private String password;
    
    // Getters and Setters
    // Unique identifier for the user entry
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;        
    }

    // Display Name
    public String getDisplayName(){
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;        
    }

    // Email
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;        
    }

    // Role - e.g., manager, user
    public String getRole(){
        return role;
    }
    public void setRole(String role) {
        this.role = role;        
    }

    // Password - sprint2 plan is to implement encryption for password storage
    public String getPassword(){
        return "******";
    }
    public void setPassword(String password) {
        this.password = password;        
    }

    public boolean isValidPassword(String password) {
        if (this.password == null || password == null) {
            return false;
        }
        return this.password.equals(password);
    }
    

}
