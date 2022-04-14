package tn.esprit.spring.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;


@Repository
public interface ClientService {
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);

	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
}
