package com.example.demo.Service;

import com.example.demo.Dao.AppUserRepository;
import com.example.demo.Dao.RoleRepository;
import com.example.demo.Entite.Admin;
import com.example.demo.Entite.AppUser;
import com.example.demo.Entite.Client;
import com.example.demo.Entite.Role;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpliment implements AccountService {

  private AppUserRepository appuserRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public AccountServiceImpliment(AppUserRepository appuserRepository, RoleRepository roleRepository,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.appuserRepository = appuserRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  // ajouter une role
  public Role save(Role role) {
    return roleRepository.save(role);
  }

  @Override
  // //affectation de role d'utilisateur
  public void addRoleToUser(String username, String rolename) {

    AppUser appUser = appuserRepository.findByUsername(username);
    Role appRole = roleRepository.findByRoleName(rolename);
    appUser.getRoleList().add(appRole);
    // userRepository.save(appUser);
  }

  @Override
  public Client saveClient(String email, String username, String mot_passe, String valide_mot_passe, String nom,
      String prenom, String telephone, String adresse) {
    AppUser user = appuserRepository.findByUsername(username);

    if (user != null)
      throw new RuntimeException("User already exists");
    if (!mot_passe.equals(valide_mot_passe))
      throw new RuntimeException("Please confirm your password");
    Client appUser = new Client();
    appUser.setEmail(email);
    appUser.setUsername(username);
    appUser.setNom(nom);
    appUser.setPrenom(prenom);
    appUser.setTelephone(telephone);
    appUser.setAdresse(adresse);

    appUser.setMot_passe(bCryptPasswordEncoder.encode(mot_passe));
    appUser.setValide_mot_passe(bCryptPasswordEncoder.encode(valide_mot_passe));

    Role role = roleRepository.findByRoleName("Client");
    if (role != null) {
      appUser.getRoleList().add(role);
      appuserRepository.save(appUser);
    }

    addRoleToUser(username, "Client");

    return appUser;
  }

  @Override
  public Admin saveAdmin(String email, String username, String mot_passe, String valide_mot_passe) {
    AppUser user = appuserRepository.findByUsername(username);

    if (user != null)
      throw new RuntimeException("User already exists");
    if (!mot_passe.equals(valide_mot_passe))
      throw new RuntimeException("Please confirm your password");
    Admin appUser = new Admin();
    appUser.setUsername(username);
    appUser.setEmail(email);
    appUser.setMot_passe(bCryptPasswordEncoder.encode(mot_passe));
    appUser.setValide_mot_passe(bCryptPasswordEncoder.encode(valide_mot_passe));

    Role role = roleRepository.findByRoleName("Admin");
    if (role != null) {
      appUser.getRoleList().add(role);
      appuserRepository.save(appUser);
    }

    addRoleToUser(username, "Admin");

    return appUser;
  }

  @Override
  public AppUser loadUserByUsername(String username) {
    return appuserRepository.findByUsername(username);
  }

}
