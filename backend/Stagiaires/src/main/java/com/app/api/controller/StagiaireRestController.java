package com.app.api.controller;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Stagiaire;
import com.app.api.repository.StagiaireRepository;
@RestController
@RequestMapping("/api/v1")
public class StagiaireRestController {

	@Autowired
	private StagiaireRepository stagiaireRepository;
	
 
	
	@GetMapping("/stage")
	public String  test(){
		return "abdelial";
	}
	
	@GetMapping("/findByNom")
	public List<Stagiaire> getAllStagiaireByNom(@RequestParam String nom){
		return stagiaireRepository.findByNom(nom);
	}
}
