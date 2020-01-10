package com.example.demo.Entite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * AppUser
 */
@Document(collection = "user")
@Component
public class AppUser {
    @Id
    private String id;
    private String email;
    private String username;
    private String mot_passe;
    private String valide_mot_passe;
    @DBRef
    private List<Role> roleList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }

    public String getValide_mot_passe() {
        return valide_mot_passe;
    }

    public void setValide_mot_passe(String valide_mot_passe) {
        this.valide_mot_passe = valide_mot_passe;
    }

    public AppUser() {
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public AppUser(String id, String email, String username, String mot_passe, String valide_mot_passe,
            List<Role> roleList) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.mot_passe = mot_passe;
        this.valide_mot_passe = valide_mot_passe;
        this.roleList = roleList;
    }

}