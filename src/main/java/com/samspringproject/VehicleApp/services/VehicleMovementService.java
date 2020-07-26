package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.VehicleMovement;
import com.samspringproject.VehicleApp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	// Returns List of countries
	public List<VehicleMovement> getVehicleMovement(){
		return vehicleMovementRepository.findAll();
		
	}
	
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	public Optional<VehicleMovement> findById(int id) {
		
		return vehicleMovementRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleMovementRepository.deleteById(id);
	}

}
