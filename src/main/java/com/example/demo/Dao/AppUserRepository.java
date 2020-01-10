package com.example.demo.Dao;

import com.example.demo.Entite.AppUser;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * AppUserRepository
 */
public interface AppUserRepository extends MongoRepository<AppUser, String> {
    AppUser findByUsername(String username);
}