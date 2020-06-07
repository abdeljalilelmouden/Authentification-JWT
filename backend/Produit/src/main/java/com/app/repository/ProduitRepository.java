package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.Produit;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
