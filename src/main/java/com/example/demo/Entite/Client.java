package com.example.demo.Entite;

import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Client
 */
@Document(collection = "user")
@TypeAlias("client")
public class Client extends AppUser {

    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Client(String id, String email, String username, String mot_passe, String valide_mot_passe,
            List<Role> roleList, String nom, String prenom, String telephone, String adresse) {
        super(id, email, username, mot_passe, valide_mot_passe, roleList);
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Client() {
    }

}