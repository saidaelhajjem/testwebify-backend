package com.example.demo.Dao;

import com.example.demo.Entite.Produit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * ProduitRepository
 */
public interface ProduitRepository extends MongoRepository<Produit, String> {
    @Query("{'id':?0}")
    public Produit getone(String id);

}