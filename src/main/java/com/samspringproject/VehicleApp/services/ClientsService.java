package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.Clients;
import com.samspringproject.VehicleApp.repositories.ClientsRepository;

@Service
public class ClientsService {
	@Autowired
	private ClientsRepository clientsRepository;
	
	// Returns List of countries
	public List<Clients> getClients(){
		return clientsRepository.findAll();
		
	}
	
	public void save(Clients clients) {
		clientsRepository.save(clients);
	}
	
	public Optional<Clients> findById(int id) {
		
		return clientsRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		clientsRepository.deleteById(id);
	}

}
