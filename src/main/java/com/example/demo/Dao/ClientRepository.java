package com.example.demo.Dao;

import com.example.demo.Entite.Client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * ClientRepository
 */
public interface ClientRepository extends MongoRepository<Client, String> {
    @Query("{'id':?0}")
    public Client getone(String id);
}