package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;

@Service

public class ProduitServiceImpl implements ProduitService {

	
	@Autowired
	ProduitRepository produitrepository;
	
	@Autowired
	StockRepository stockrepository;
	
	@Autowired
	RayonRepository rayonrepository;
	
	
	@Override
	public List<Produit> retrieveAllProduits() {
		
		return (List<Produit>) produitrepository.findAll();
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		Rayon rayon = rayonrepository.findById(idRayon).orElse(null);
		Stock stock = stockrepository.findById(idStock).orElse(null);
		p.setRayons(rayon);
		p.setStocks(stock);
		produitrepository.save(p);
		return p ; 
		
	}
	
	

	@Override
	public Produit retrieveProduit(Long id) {
		Produit p= produitrepository.findById(id).get();
		return p;
	}

	@Override
	public Produit addProduitDetailsProduits(Produit p) {
	
		return produitrepository.save(p);
	}

	@Override
	public Produit AffectProduitRayon(Long idProduit, Long IdRayon) {
		Rayon rayon = rayonrepository.findById(IdRayon).orElse(null);
		Produit produit = produitrepository.findById(idProduit).orElse(null);
		produit.setRayons(rayon);
		return produit ;
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitrepository.save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		 produitrepository.deleteById(id);
		
	}

}
