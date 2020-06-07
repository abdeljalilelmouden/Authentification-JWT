package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.entity.Categorie;
import com.app.entity.Produit;
import com.app.repository.CategorieRepository;
import com.app.repository.ProduitRepository;

@SpringBootApplication
public class ProduitApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);
	}

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Categorie c1 = categorieRepository.save(new Categorie(null,"TELEPHONE", null));
		Categorie c2 = categorieRepository.save(new Categorie(null,"TELEVISION", null));
		Categorie c3 = categorieRepository.save(new Categorie(null,"PC PORTABLE", null));

		produitRepository.save(new Produit(null, "Infinx Phone","200 DH","assets/images/produits/150.png",c1));
		produitRepository.save(new Produit(null, "Toshiba Pc","200 DH","assets/images/produits/150.png",c2));
		produitRepository.save(new Produit(null, "Smart Tv","200 DH","assets/images/produits/150.png",c2));
		
		
		
	}

}
