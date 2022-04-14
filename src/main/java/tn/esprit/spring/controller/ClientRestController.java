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
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.ClientService;

@RestController

@Api(tags = "Gestion des Clients")
@RequestMapping("/client")
public class ClientRestController {
	
	@Autowired
	ClientService clientservice;
	
	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")
	public List<Client> getClients() {
	List<Client> listClients = clientservice.retrieveAllClients();
	return listClients;
	}
	
	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@GetMapping("/retrieve-client/{client-id}")
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
	return clientservice.retrieveClient(clientId);
	}
	
	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-client")
	public Client addClient(@RequestBody Client c) {
	return clientservice.addClient(c);
	}

	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	public void removeClient(@PathVariable("client-id") Long clientId) {
	clientservice.deleteClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	public Client modifyClient(@RequestBody Client client) {
	return clientservice.updateClient(client);
	}
}
