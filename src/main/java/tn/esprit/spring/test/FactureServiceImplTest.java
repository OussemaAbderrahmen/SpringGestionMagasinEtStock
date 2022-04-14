package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entity.Facture;

import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.service.FactureService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {
	
	@Autowired
	FactureService factureService;
	@Autowired
	FactureRepository factureRepository;
	
	@Test
	public void testRetrieveAllFactures(){
		List<Facture> factures = factureService.retrieveAllFactures();
		assertEquals(4,factures.size());
	}
	
	@Test
	public void testCancelFacture(){
		
	
		factureRepository.deleteById(19L);
		  assertThat(factureService.retrieveFacture(1L));

	}

	@Test
	public void retrieveFacture() {
		factureRepository.findById(4L);
		assertThat(factureService.retrieveFacture(4L));

	}
}
