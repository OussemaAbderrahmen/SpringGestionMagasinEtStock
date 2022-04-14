package tn.esprit.spring.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Stock;


@Repository
public interface StockService {
	
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	void deleteStock(Long id);
	
	Stock retrieveStock(Long id);

}
