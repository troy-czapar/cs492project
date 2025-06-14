package com.cs492.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs492.repositories.MenuStorage;
import com.cs492.entities.MenuEntries;


@RestController
@RequestMapping("/v1/Menu")
public class Menu {

    // Define private menu array
    private final MenuStorage menu;

    // Default Constructor
    public Menu(MenuStorage menu){
        this.menu = menu;
    }

    // Get a Menu entry by ID
    @GetMapping("/{id}")
    public Optional<MenuEntries> getMenuEntry(@PathVariable("id") Long id) {
        return menu.findById(id);
    }

    // Get all Menu entries
    @GetMapping("/")
    public Iterable<MenuEntries> getMenu() {
        return menu.findAll();
    }

    // Add a Menu Entry
    @PostMapping("/")
    public MenuEntries addMenuEntry(@RequestBody MenuEntries menuEntry) {
        menu.save(menuEntry);
        return menuEntry;
    }
    
}
