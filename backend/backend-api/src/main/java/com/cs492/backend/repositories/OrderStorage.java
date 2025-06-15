package com.cs492.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs492.backend.entities.OrderEntries;

// This interface defines the repository for OrderEntries, allowing CRUD operations on the order storage.

@Repository
public interface OrderStorage extends CrudRepository<OrderEntries, Long> {

}