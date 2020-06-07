package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.AppRole;

@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole, Long>{

	public AppRole findByNomRole(String nomRole);
}
