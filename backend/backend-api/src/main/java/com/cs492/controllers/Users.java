package com.cs492.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs492.entities.LoginEntity;
import com.cs492.entities.UserEntries;
import com.cs492.repositories.UserStorage;

@RestController
@RequestMapping("/v1/Users")
public class Users {

    // Define private menu array
    private final UserStorage users;

    // Default Constructor
    public Users(UserStorage users){
        this.users = users;
    }

    // Get a User by ID
    @GetMapping("/{id}")
    public Optional<UserEntries> getUser(@PathVariable("id") Long id) {
        return users.findById(id);
    }
    // Get all Users
    @GetMapping("/")
    public Iterable<UserEntries> getUsers() {
        return users.findAll();
    }

    // Add a User
    @PostMapping("/")
    public UserEntries addUser(@RequestBody UserEntries userEntry) {
        users.save(userEntry);
        return userEntry;
    }

    // login
    // @PostMapping("/login")
    // public Boolean login(@RequestBody LoginEntity loginInfo) {
    //     users.
    //     return userEntry;
    // }

    
}
