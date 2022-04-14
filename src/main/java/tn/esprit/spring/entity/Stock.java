package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="Stock")

public class Stock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idStock; 
	
	@NonNull private int qteStock;

	@NonNull private int qteMin;

	@NonNull private String libelleStock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stocks")
	@JsonIgnore
	@JsonBackReference
	@ToString.Exclude
	private Set<Produit> produit;
	
	
	public Stock(String libelleStock,int qte, int qteMin) {
		super();
		this.libelleStock = libelleStock;
		this.qteStock = qte;
		this.qteMin = qteMin;
		
	}
	
	public Stock(Long id,String libelleStock,int qte, int qteMin) {
		
		this.idStock=id;
		this.libelleStock = libelleStock;
		this.qteStock = qte;
		this.qteMin = qteMin;
		
	}
	
}
