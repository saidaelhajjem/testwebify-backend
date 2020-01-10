package com.example.demo.Dao;

import com.example.demo.Entite.Role;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * RoleRepository
 */
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRoleName(String roleName);

}