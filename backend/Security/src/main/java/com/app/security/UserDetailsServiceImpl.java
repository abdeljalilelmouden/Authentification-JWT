package com.app.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entity.AppUser;
import com.app.service.AcountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AcountService acountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = acountService.loadUserByUsername(username);
		if(appUser == null) throw new UsernameNotFoundException("Utilisateur n'exist pas ");
		
		Collection<GrantedAuthority> authority = new ArrayList<>();
		appUser.getRoles().forEach(r->{
			authority.add(new SimpleGrantedAuthority(r.getNomRole()));
		});
		
		return new User( appUser.getUsername(), appUser.getPassword(), authority);
	}
	

}
