package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.AppUser;
import com.app.service.AcountService;

@RestController
public class UserController {

	@Autowired
	private AcountService acountService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody UserForm userForm) {
		return acountService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
	}
}

class UserForm{
	private String username;
	private String password;
	private String confirmedPassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
	
}
