package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;


@Service
@Slf4j
public class StockServiceImpl implements StockService{

	
	@Autowired
	StockRepository stockrepository;
	
	/*@Override
	public List<Stock> retrieveAllStocks() {
		
		return (List<Stock>) stockrepository.findAll();
	}*/
	
	@Override
	public List<Stock> retrieveAllStocks() {
	List<Stock> stocks = null;
	try {
	log.info("In method retrieveStock");
	log.debug("Connection à la base de données : ");
	stocks = (List<Stock>) stockrepository.findAll();
	log.debug("Le nombre total de Stocks : " + stocks.size());
	for (Stock stock : stocks) {
	log.debug(" Stock : " + stock.toString());
	}
	log.info("Out method retrieveStock without Errors");
	}
	catch (Exception e) {log.error("Error in retrieveStock : " + e);}
	return stocks;
	}
	

	@Override
	public Stock addStock(Stock s) {
		log.info("In method addStock");

		return stockrepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		return stockrepository.save(u);
	}

	/*@Override
	public Stock retrieveStock(Long id) {
		Stock s =null;
		try {
			s = stockrepository.findById(id).get();
		} catch (Exception e) {
			
		}
		
		return s ;
	}*/
	
	public Stock retrieveStock(Long stockId) {
		Stock stock = null;
		try {
		log.info("In method retrieveStock");
		log.debug("je vais me conencter à la base de données : ");
		stock = stockrepository.findById(stockId).orElse(null);
		log.debug("le stock trouvé est : " + stock);
		log.info("Out method retrieveStock without Errors");
		} catch (Exception e) {
		log.error("Error in retrieveStock : " + e);
		}
		return stock;
		}

	/*@Override
	public void deleteStock(Long id) {
		stockrepository.deleteById(id);
	}*/
	@Override
	public void deleteStock(Long id) {
		log.info("In Method delete stock");
		log.info("je vais supprimé un stock");
		stockrepository.deleteById(id);
		log.info("out Method delete stock without errors");

	}
	
	
	/*@Scheduled(fixedRate=6000)
	public void testScheduling(){
		if(stockrepository.count()<=60){
			retrieveAllStocks();
		}
	}*/
	
}
