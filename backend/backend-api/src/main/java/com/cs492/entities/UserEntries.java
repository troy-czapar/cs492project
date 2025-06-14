package com.cs492.entities;


import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class UserEntries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String displayName;
    private String email;
    private String role;
    private String password;
    

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;        
    }



    public String getDisplayName(){
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;        
    }

    
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;        
    }

    public String getRole(){
        return role;
    }
    public void setRole(String role) {
        this.role = role;        
    }

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
