package com.example.demo.Controlleur;

import com.example.demo.Dao.ClientRepository;
import com.example.demo.Entite.Client;
import com.example.demo.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientRestCont
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/client")
public class ClientRestCont {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public Client ajouterClient(@RequestBody Client client) {

        return accountService.saveClient(client.getEmail(), client.getUsername(), client.getMot_passe(),
                client.getValide_mot_passe(), client.getNom(), client.getPrenom(), client.getTelephone(),
                client.getAdresse());
    }

}