package com.cs492.backend.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs492.backend.entities.MenuEntries;

// This interface defines the repository for MenuEntries, allowing CRUD operations on the menu storage.

@Repository
public interface MenuStorage extends CrudRepository<MenuEntries, Long> {

}