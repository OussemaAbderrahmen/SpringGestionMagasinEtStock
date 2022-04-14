package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class DetailFacture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetailFacture;
	
	 @NonNull private int qte;
	 @NonNull private float prixTotal;
	 @NonNull private int pourcentageRemise;
	 @NonNull private int montantRemise;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	Facture factures;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JsonIgnore
	@JsonBackReference
	@ToString.Exclude
	Produit produits;
	
	
	
	
	
	
	

}
