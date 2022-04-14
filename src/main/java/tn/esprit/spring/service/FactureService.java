package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Facture;

@Repository
public interface FactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	Facture addFacture(Facture f);
	
	void deleteFacture(Long id);
}
