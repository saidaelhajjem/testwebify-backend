package com.example.demo.Entite;

import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Admin
 */
@Document(collection = "user")
@TypeAlias("admin")
public class Admin extends AppUser {

    public Admin() {
    }

    public Admin(String id, String email, String username, String mot_passe, String valide_mot_passe,
            List<Role> roleList) {
        super(id, email, username, mot_passe, valide_mot_passe, roleList);
    }

}