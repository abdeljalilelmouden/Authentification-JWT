package com.app.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource; 

import com.app.api.entity.Stagiaire;
 
@RepositoryRestResource
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
	
	
	public List<Stagiaire> findByNom(String nom);
	

}
