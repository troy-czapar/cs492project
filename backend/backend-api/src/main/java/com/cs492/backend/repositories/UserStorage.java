package com.cs492.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs492.backend.entities.UserEntries;

// This interface defines the repository for UserEntries, allowing CRUD operations on the user storage.

@Repository
public interface UserStorage extends CrudRepository<UserEntries, Long> {

}
