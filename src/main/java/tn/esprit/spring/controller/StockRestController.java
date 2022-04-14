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
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockService;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/Stock")
public class StockRestController {
	@Autowired
	StockService Stockservice;
	
	// http://localhost:8089/SpringMVC/Stock/retrieve-all-Stocks
	@GetMapping("/retrieve-all-Stocks")
	public List<Stock> getStocks() {
	List<Stock> listStocks = Stockservice.retrieveAllStocks();
	return listStocks;
	}
	
	// http://localhost:8089/SpringMVC/Stock/retrieve-Stock/8
	@GetMapping("/retrieve-Stock/{Stock-id}")
	public Stock retrieveStock(@PathVariable("Stock-id") Long StockId) {
	return Stockservice.retrieveStock(StockId);
	}
	
	// http://localhost:8089/SpringMVC/Stock/add-Stock
	@PostMapping("/add-Stock")
	public Stock addStock(@RequestBody Stock c) {
	return Stockservice.addStock(c);
	}

	// http://localhost:8089/SpringMVC/Stock/remove-Stock/{Stock-id}
	@DeleteMapping("/remove-Stock/{Stock-id}")
	public void removeStock(@PathVariable("Stock-id") Long StockId) {
	Stockservice.deleteStock(StockId);
	}

	// http://localhost:8089/SpringMVC/Stock/modify-Stock
	@PutMapping("/modify-Stock")
	public Stock modifyStock(@RequestBody Stock stock) {
	return Stockservice.updateStock(stock);
	}
}
