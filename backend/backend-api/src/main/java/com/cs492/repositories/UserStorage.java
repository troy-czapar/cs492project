package com.cs492.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs492.entities.UserEntries;

@Repository
public interface UserStorage extends CrudRepository<UserEntries, Long> {

}
