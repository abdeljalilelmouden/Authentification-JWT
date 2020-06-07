package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.Categorie;

@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
