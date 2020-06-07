package com.app.service;

import com.app.entity.AppRole;
import com.app.entity.AppUser;

public interface AcountService {
	
	public AppUser saveUser(String username, String password, String confirmedPassword);
	
	public AppRole saveRole(AppRole appRole);
	
	public AppUser loadUserByUsername(String username);
	
	public void addRoleToUser(String username, String nomRole);

}
