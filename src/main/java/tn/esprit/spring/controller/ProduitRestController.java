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
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService;

@RestController

@Api(tags = "Gestion des Produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	ProduitService produitservice;

	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	public List<Produit> getproduits() {
		List<Produit> listproduits = produitservice.retrieveAllProduits();
		return listproduits;
	}

	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	@GetMapping("/retrieve-produit/{produit-id}")
	public Produit retrieveproduit(@PathVariable("produit-id") Long produitId) {
		return produitservice.retrieveProduit(produitId);
	}

	// http://localhost:8089/SpringMVC/produit/add-produit/{idRayon}/{idStock}
	@PostMapping("/add-produit/{idRayon}/{idStock}")
	public Produit addproduit(@RequestBody Produit P, @PathVariable Long idRayon, @PathVariable Long idStock) {
		return produitservice.addProduit(P, idRayon, idStock);
	}

	// http://localhost:8089/SpringMVC/produit/update-produit
	@PutMapping("/update-produit")
	public Produit updateproduit(@RequestBody Produit P) {
		return produitservice.updateProduit(P);
	}

	// http://localhost:8089/SpringMVC/produit/delete-produit/{Produit-id}
	@DeleteMapping("/delete-produit/{Produit-id}")
	public void deleteproduit(@PathVariable("Produit-id") Long id) {
		produitservice.deleteProduit(id);
	}

	// http://localhost:8089/SpringMVC/produit/addProduit
	@PostMapping("/addProduit")
	public Produit addproduit(@RequestBody Produit P) {
		return produitservice.addProduitDetailsProduits(P);
	}

}
