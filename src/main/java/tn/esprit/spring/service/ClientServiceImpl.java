package tn.esprit.spring.service;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

	
	@Autowired
	ClientRepository clientrepository;
	@Autowired
	FactureRepository factureRepository;
	
	
	
	@Override
	public List<Client> retrieveAllClients() {
	List<Client> clients = null;
	try {
	/*log.info("In method retrieveClient");
	log.debug("Connection à la base de données : ");*/
	 clients = (List<Client>)clientrepository.findAll();
	//log.debug("Le nombre total de clients : " + clients.size());
	for (Client client : clients) {
	log.debug(" Client : " + client.toString());
	}
//	log.info("Out method retrieveClient without Errors");
	}
	catch (Exception e) {log.error("Error in retrieveClient : " + e);}
	
	
return clients;
	}
	
	
	public Client retrieveClient(Long cliendId) {
		Client client = null;
		try {
		//log.info("In method retrieveClient");
		//log.debug("je vais me connecter à la base de données : ");
		client = clientrepository.findById(cliendId).orElse(null);
		//log.debug("le client trouvé est : " + client);
		//log.info("Out method retrieveClient without Errors");
		} catch (Exception e) {
		///log.error("Error in retrieveClient : " + e);
		}
		return client;
		}
	

	@Override
	public Client addClient(Client c) {
		log.info("In Method addClient");
		return clientrepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {
		log.info("In Method deleteClient");
		clientrepository.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client c) {
		
		log.info("In Method UpdateClient");
		return clientrepository.save(c);
		
	}
	
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,Date startDate,Date endDate){
		List<Facture> listFacture = factureRepository.retrieveFactureByDate(startDate, endDate);
		List<Client> listClient = clientrepository.findByCategorieClient(categorieClient);
		float CA =0;
		for(Client c:listClient){
			for(Facture f:c.getFacture()){
				CA+=(f.getMontantFacture()-f.getMontantRemise());
			}
		}
		return CA;
	}

	/*@Override
	public Client retrieveClient(Long id) {
		Client c = clientrepository.findById(id).get();
		return c;
	}*/
	/*@Override
	public List<Client> retrieveAllClients() {
		log.info("In Method Retrieve All Clients");
		List<Client> clients= (List<Client>) clientrepository.findAll();
		for(Client client : clients){
			log.info("client : "+client);
		}
		return clients;
	}*/
}
