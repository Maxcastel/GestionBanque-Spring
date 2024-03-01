package com.gestionbanque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestionbanque.dao.ClientRepository;
import com.gestionbanque.dao.CompteRepository;
import com.gestionbanque.dao.OperationRepository;
import com.gestionbanque.entities.Client;
import com.gestionbanque.entities.Compte;
import com.gestionbanque.entities.CompteCourant;
import com.gestionbanque.entities.CompteEpargne;
import com.gestionbanque.entities.Operation;
import com.gestionbanque.entities.Retrait;
import com.gestionbanque.entities.Versement;
import com.gestionbanque.metier.BanqueMetier;
import com.gestionbanque.metier.IBanqueMetier;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private IBanqueMetier banqueMetier;

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
		//System.out.println("cc");
	}
	
	//public void run(ApplicationArguments args)
	@Override
	public void run(String... arg0) throws Exception{
		
		
		//banqueMetier.virement("CC1", "CC3", 5000);
		
		/*Client c = clientRepository.findById(4).get();
		c.setNom("Jean Dupontt");
		clientRepository.save(c);*/
		
		/*Client p1 = clientRepository.save(new Client("Jean Dupont", "jean.dupont@example.com"));
		Client p2 = clientRepository.save(new Client("Marie Durand", "marie.durand@example.com"));
		Client p3 = clientRepository.save(new Client("Pierre Martin", "pierre.martin@example.com"));
	
		
		Compte c1 = compteRepository.save(new CompteCourant("CC1", new Date(), 50000, p1, 1000));
		Compte c2 = compteRepository.save(new CompteCourant("CC2", new Date(), 30000, p1, 1000));
		Compte c3 = compteRepository.save(new CompteCourant("CC3", new Date(), 80000, p2, 1000));

		Compte c4 = compteRepository.save(new CompteEpargne("CE1", new Date(), 50000, p3, 5.5));
	
		
		operationRepository.save(new Versement(new Date(), 200, c1));
		operationRepository.save(new Retrait(new Date(), 4000, c2));
		operationRepository.save(new Versement(new Date(), 100, c3));
		operationRepository.save(new Retrait(new Date(), 3000, c4));*/
		
	}
	

}
