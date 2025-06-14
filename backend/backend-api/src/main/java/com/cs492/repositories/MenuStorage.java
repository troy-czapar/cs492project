package com.cs492.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs492.entities.MenuEntries;

@Repository
public interface MenuStorage extends CrudRepository<MenuEntries, Long> {

}