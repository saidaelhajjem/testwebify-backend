package com.example.demo.Controlleur;

import com.example.demo.Dao.AdminRepository;
import com.example.demo.Entite.Admin;
import com.example.demo.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminRestCont
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminRestCont {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public Admin ajouterAdmin(@RequestBody Admin admin) {

        return accountService.saveAdmin(admin.getEmail(), admin.getUsername(), admin.getMot_passe(),
                admin.getValide_mot_passe());
    }

}