package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.ProduitService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
	
	@Autowired
	ProduitService productService ;
	
	@Autowired
	ProduitRepository productRepositrory;	
	
	@Autowired
	RayonRepository rayonRepository;
	
	@Autowired
	StockRepository stockRepository;
	
	@Test
	public void retrieveStock() {
		productRepositrory.findById(2L);
		assertThat(productService.retrieveProduit(2L));

	}
	

	@Test
	public void testAddProduct() {
		Produit p = new Produit("ee","product test",15);
		
			Produit savedProduct= productService.addProduit(p, null, null);
			assertEquals(p.getIdProduit(),savedProduct.getIdProduit());
			
	
	}
	
	@Test
	public void testRetrieveAllProducts(){
		List<Produit> produits = productService.retrieveAllProduits();
		assertEquals(4,produits.size());
	}
	
	
	


}
