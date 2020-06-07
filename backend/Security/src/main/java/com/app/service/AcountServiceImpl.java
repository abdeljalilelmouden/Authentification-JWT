package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.AppRole;
import com.app.entity.AppUser;
import com.app.repository.AppRoleRepository;
import com.app.repository.AppUserRepository;

@Service
@Transactional
public class AcountServiceImpl implements AcountService{

	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public AppUser saveUser(String username, String password, String confirmedPassword) {
		AppUser user = appUserRepository.findByUsername(username);
		// vÃ©rification si l'utilisateur existe
		if(user != null) throw new RuntimeException("Username exixte !!");
		// vÃ©rification si les deux mot de pass equal
		if(!password.equals(confirmedPassword)) throw new RuntimeException("les deux mot de pass sant pas equal !!");
		
		AppUser appUser = new AppUser(); 
		appUser.setUsername(username); // Enregister le username
		appUser.setActived(true); // Enregister Etat
		appUser.setPassword(bCryptPasswordEncoder.encode(password)); // Enregister le mot de passe
		appUserRepository.save(appUser);
		addRoleToUser(username, "USER");
		return appUser;
	}

	@Override
	public AppRole saveRole(AppRole appRole) {
		return appRoleRepository.save(appRole);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String nomRole) {
		AppUser appUser = appUserRepository.findByUsername(username);
		AppRole appRole = appRoleRepository.findByNomRole(nomRole);
		appUser.getRoles().add(appRole);
		
	}


	
 
}
