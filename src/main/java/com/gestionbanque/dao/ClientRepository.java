package com.gestionbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionbanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
}
