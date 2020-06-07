package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.entity.AppRole;
import com.app.entity.AppUser;
import com.app.service.AcountService;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	
	@Autowired
	private AcountService acountService;

	@Override
	public void run(String... args) throws Exception {
		 
		acountService.saveRole(new AppRole(null, "ADMIN"));
		acountService.saveRole(new AppRole(null, "USER"));
		
		acountService.saveUser("admin", "admin", "admin");
		acountService.saveUser("user", "user", "user");
		
		acountService.addRoleToUser("admin", "ADMIN");
	 
	}
	
	@Bean 
	BCryptPasswordEncoder getBCPE() { 
		return new BCryptPasswordEncoder(); 
	}

}
