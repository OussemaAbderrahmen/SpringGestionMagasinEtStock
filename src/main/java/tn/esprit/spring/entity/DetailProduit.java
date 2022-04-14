package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class DetailProduit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetailProduit ;
	
	@Temporal(TemporalType.DATE)
	@NonNull private Date dateCreation ; 
	
	
	
	@Temporal(TemporalType.DATE)
	@NonNull private Date dateDerniereModification;
	
	
	@Enumerated(EnumType.ORDINAL)
	@NonNull CategorieProduit categorieProduit;
	
	@OneToOne(mappedBy="detailProduit", cascade=CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private Produit produit;
	
	
	
	

	
	
}
