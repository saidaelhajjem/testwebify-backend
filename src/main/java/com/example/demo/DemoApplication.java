package com.example.demo;

import java.util.Collections;
import javax.annotation.Resource;
import com.example.demo.Entite.Role;
import com.example.demo.Photo.StorageService;
import com.example.demo.Dao.RoleRepository;

import com.example.demo.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	// @Resource
	// StorageService storageService;
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	 * @Bean CommandLineRunner start(AccountService accountService) { return args ->
	 * { accountService.save(new Role("Client")); accountService.save(new
	 * Role("Admin"));
	 * 
	 * }; }
	 */
	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// storageService.deleteAll();
		// storageService.init();

	}

}
