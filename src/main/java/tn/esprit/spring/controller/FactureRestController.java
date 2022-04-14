package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.FactureService;


@RestController

@Api(tags = "Gestion des Factures")
@RequestMapping("/facture")
public class FactureRestController {
	@Autowired
	FactureService factureservice;
	
	// http://localhost:8089/SpringMVC/facture/retrieve-all-factures
	@GetMapping("/retrieve-all-factures")
	public List<Facture> getfactures() {
	List<Facture> listFactures = factureservice.retrieveAllFactures();
	return listFactures;
	}
	
	// http://localhost:8089/SpringMVC/facture/retrieve-facture/8
	@GetMapping("/retrieve-facture/{facture-id}")
	public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
	return factureservice.retrieveFacture(factureId);
	}
	
	// http://localhost:8089/SpringMVC/facture/add-facture
	@PostMapping("/add-facture")
	public Facture addfacture(@RequestBody Facture f) {
	return factureservice.addFacture(f);
	}

	// http://localhost:8089/SpringMVC/facture/remove-facture/{facture-id}
	@DeleteMapping("/remove-facture/{facture-id}")
	public void removefacture(@PathVariable("facture-id") Long factureId) {
	factureservice.deleteFacture(factureId);
	}

	// http://localhost:8089/SpringMVC/facture/modify-facture/{facture-id}
	@PutMapping("/modify-facture/{facture-id}")
	public void modifyfacture(@PathVariable("facture-id") Long idfacture) {
	 factureservice.cancelFacture(idfacture);
	}
}
