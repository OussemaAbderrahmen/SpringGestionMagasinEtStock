package tn.esprit.spring.test;


import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Client;

import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.service.ClientService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {
	@Autowired
	ClientService iClientService;
	@Autowired
	ClientRepository clientRepository;
	
	@Test
	public void testAddClient() {
		Client c = new Client("test","this test");
		
			Client savedClient= iClientService.addClient(c);
			assertEquals(c.getNom(),savedClient.getNom());
			
	
	}
	
	/*@Test
	public void testDeleteClientById(){
		
	
		clientRepository.deleteById(18L);
		  assertThat(clientRepository.count()).isEqualTo(1);

	}
	
	@Test
	public void testSuppAllClient(){
		
		clientRepository.deleteAll();
		  assertThat(clientRepository.count()).isEqualTo(0);
	}*/
	
    /*@Test
	public void testUpdateClient(){
		 Client client = iClientService.updateClient();
	}*/
	
	
	
}
