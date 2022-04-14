package tn.esprit.spring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;

public interface FactureRepository extends CrudRepository<Facture, Long> {

   List<Facture> findByClients(Client clients);
	@Query(value="SELECT f FROM Facture f WHERE f.dateFacture between :date1 and :date2")
			List<Facture> retrieveFactureByDate(@Param("date1") Date date1,@Param("date2")Date date2);
	
	
	
}
