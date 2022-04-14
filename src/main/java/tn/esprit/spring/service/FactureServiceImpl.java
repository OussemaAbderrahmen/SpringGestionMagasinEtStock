package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;
@Service
@Slf4j
public class FactureServiceImpl implements FactureService{

	
	@Autowired
	FactureRepository facturerepository;
	
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = null;
		try {
			log.info("In method retrieveFacture");
			log.debug("Connection à la base de données : ");
			factures = (List<Facture>)facturerepository.findAll();
			log.debug("Le nombre total des factures : " + factures.size());
			for (Facture facture : factures) {
				log.debug(" facture : " + facture.toString());
			}
			log.info("Out method retrieveFacture without Errors");
		} catch (Exception e) {
			log.error("Error in retrieveFacture : " + e);
		}
		return factures;
	}
	
	@Override
	public void cancelFacture(Long id) {
		try{
			log.info("In method cancelFacture");
			log.debug("Conenction à la base de données : ");
			Facture f = facturerepository.findById(id).get();
			f.setActive(false);
			log.info("Out method cancelFacture without Errors");
		}catch (Exception e) {
			log.error("Error in cancelFacture : " + e);
		}
		

	}
	@Override
	public Facture retrieveFacture(Long factureId) {
		Facture facture = null;
		try {
			log.info("In method retrieveStock");
			log.debug("je vais me conencter à la base de données : ");
			facture = facturerepository.findById(factureId).orElse(null);
			log.debug("le nombre de facture trouvée est : " + facture);
			log.info("Out method retrieveFacture without Errors");
		} catch (Exception e) {
			log.error("Error in retrieveFacture : " + e);
		}
		return facture;
	}

	
	@Override
	public Facture addFacture(Facture f) {
		
		return facturerepository.save(f);
	}

	@Override
	public void deleteFacture(Long id) {
		try{
		log.info("In method CAncelFacture");
		log.debug("Conenction à la base de données : ");
		facturerepository.deleteById(id);
		log.info("Out method retrieveFacture without Errors");
		}catch (Exception e) {
			log.error("Error in cancelFacture : " + e);
		}
		
	}
	
	
	@Scheduled(cron = "* * * 1 1 *")
	public void calculRevenuMagasin(){
		float revenue=0;
		List<Facture>f;
		f=(List<Facture>)facturerepository.findAll();
		for(Facture facture :f){
			revenue+=facture.getMontantFacture();
		}
		log.info("le revenue du magasin est :" + revenue);
	}
	
	
	/*	@Override
	public void deleteFacture(Long id) {
		facturerepository.deleteById(id);
		
	}*/
	
	
	/*@Override
	public List<Facture> retrieveAllFactures() {
		return (List<Facture>) facturerepository.findAll();
	}*/

	/*@Override
	public void cancelFacture(Long id) {
		Facture f = facturerepository.findById(id).get();
		f.setActive(false);
		
	}*/
	

	/*@Override
	public Facture retrieveFacture(Long id) {
		Facture f = facturerepository.findById(id).get();
		return f;
	}*/
}
