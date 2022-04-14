package tn.esprit.spring.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

	@Autowired
	StockService stockService;

	@Autowired
	StockRepository stockRepositoty;

	@Test
	public void testAddStock() {
		Stock s = new Stock(null, 10, 100, "stock test", null);
		Stock savedStock = stockService.addStock(s);
		assertEquals(s.getLibelleStock(), savedStock.getLibelleStock());
	}

	@Test
	public void testDeleteStock() {
		stockService.deleteStock(4L);
		assertNull(stockService.retrieveStock(4L));
	}

	@Test
	public void testupdateStock() {
		Stock s = new Stock(2L, 20, 100, "update", null);
		Stock savedStock = stockService.updateStock(s);
		assertEquals(s.getLibelleStock(), savedStock.getLibelleStock());
	}

	@Test
	public void testRetrieveAllStocks() {
		List<Stock> allStocks = stockService.retrieveAllStocks();
		assertEquals(1, allStocks.size());
	}

}
