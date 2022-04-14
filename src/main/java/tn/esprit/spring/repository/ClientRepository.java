package tn.esprit.spring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {
	
    List<Client> findByCategorieClient(CategorieClient categorieclient);
	@Query(value="SELECT c FROM Client c WHERE f.category_client =:categoryClient ")
	List<Client> retrieveClientsByCategory(@Param("categoryClient") CategorieClient categoryClient);
}
