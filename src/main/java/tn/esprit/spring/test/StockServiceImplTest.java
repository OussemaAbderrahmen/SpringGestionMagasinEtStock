package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.StockService;





@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

	@Autowired
	StockService stockService;
	
	@Autowired
	StockRepository stockRepository;
	
	@Test
	public void testAddStock() {
		Stock s = new Stock("this test", 10, 100);

		if (s.getLibelleStock().equals(s.getLibelleStock())) {
			Stock savedStock = stockService.addStock(s);

			assertEquals(s.getLibelleStock(), savedStock.getLibelleStock());

		}

	}
	
	/*@Test
	public void testSuppAllStock(){
		
		  stockRepository.deleteAll();
		  assertThat(stockRepository.count()).isEqualTo(0);
	}*/
	
	
	@Test
	public void testDeleteStockById(){
		
	
		stockRepository.deleteById(19L);
		  assertThat(stockService.retrieveStock(21L));

	}
	
	@Test
	public void testRetrieveAllStock(){
		List<Stock> stocks = stockService.retrieveAllStocks();
		assertEquals(11,stocks.size());
	}
	
	@Test
	public void testUpdateStock(){
		Stock s = new Stock(25L,"biscuit",23,103);
		Stock updatedStock=stockService.updateStock(s);
		assertEquals(s.getLibelleStock(), updatedStock.getLibelleStock());
		
	}
	
	@Test
	public void retrieveStock() {
		stockRepository.findById(25L);
		assertThat(stockService.retrieveStock(25L));

	}
	
	
}
