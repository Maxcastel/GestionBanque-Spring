package com.gestionbanque.entities;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="compte_type", 
discriminatorType = DiscriminatorType.STRING, length=2)
public abstract class Compte {
	
	@Id
	private String codeCompte;
	
	@Column
	private Date dateCreation;
	
	@Column
	private double solde;
	
	@ManyToOne
	@JoinColumn(name="code_client")
	private Client client;
	
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	
	public Compte() {
		
	}

	public Compte(String codeCompte, Date dateCreation, double solde, Client client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [codeCompte=" + codeCompte + ", dateCreation=" + dateCreation + ", solde=" + solde + ", client="
				+ client + "]";
	}
	
	
	

}
