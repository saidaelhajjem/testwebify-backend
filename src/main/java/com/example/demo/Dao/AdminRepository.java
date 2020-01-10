package com.example.demo.Dao;

import com.example.demo.Entite.Admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * AdminRepository
 */
public interface AdminRepository extends MongoRepository<Admin, String> {
    @Query("{'id':?0}")
    public Admin getone(String id);
}