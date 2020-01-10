package com.example.demo.Controlleur;

import java.util.List;

import com.example.demo.Dao.ProduitRepository;
import com.example.demo.Entite.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProduitRestCont
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/produit")
public class ProduitRestCont {
    @Autowired
    private ProduitRepository produitRepository;

    @PostMapping("/add")
    public Produit ajouterProduit(@RequestBody Produit produit) {

        return produitRepository.save(produit);
    }

    @GetMapping("/getone/{id}")
    public Produit getone(@PathVariable String id) {
        return produitRepository.getone(id);
    }

    @GetMapping("/getall")
    public List<Produit> getall() {
        return produitRepository.findAll();
    }
}