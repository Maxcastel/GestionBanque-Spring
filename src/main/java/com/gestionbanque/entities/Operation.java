package com.gestionbanque.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="operation_type", 
discriminatorType = DiscriminatorType.STRING, length=1)
public abstract class Operation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	
	@Column
	private Date dateOperation;
	
	@Column
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="code_compte")
	private Compte compte;

	public Operation() {

	}

	public Operation(Date dateOperation, double montant, Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}

	public int getNumero() {
		return numero;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Operation [numero=" + numero + ", dateOperation=" + dateOperation + ", montant=" + montant + ", compte="
				+ compte + "]";
	}

	
}
