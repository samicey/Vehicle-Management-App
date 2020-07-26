package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.Vehicle;
import com.samspringproject.VehicleApp.repositories.VehicleRepository;

@Service
public class VehicleService {
	

	@Autowired
	private VehicleRepository vehicleRepository;
	
	// Returns List of Vehicle 
	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
		
	}
	
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	public Optional<Vehicle> findById(int id) {
		
		return vehicleRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleRepository.deleteById(id);
	}


}
