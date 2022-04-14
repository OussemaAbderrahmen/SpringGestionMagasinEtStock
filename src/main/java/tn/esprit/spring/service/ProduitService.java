package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Produit;

@Repository
public interface ProduitService {

	
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
	Produit addProduitDetailsProduits(Produit p );
	Produit AffectProduitRayon(Long idProduit , Long IdRayon);
	Produit updateProduit(Produit p );
	void deleteProduit(Long id );
	
}
