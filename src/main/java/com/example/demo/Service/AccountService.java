package com.example.demo.Service;

import com.example.demo.Entite.Admin;
import com.example.demo.Entite.AppUser;
import com.example.demo.Entite.Client;
import com.example.demo.Entite.Role;

public interface AccountService {
  Client saveClient(String email, String username, String mot_passe, String valide_mot_passe, String nom, String prenom,
      String telephone, String adresse);

  Admin saveAdmin(String email, String username, String mot_passe, String valide_mot_pass);

  Role save(Role role);

  AppUser loadUserByUsername(String username);

  void addRoleToUser(String username, String rolename);
}
