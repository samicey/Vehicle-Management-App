package com.samspringproject.VehicleApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.VehicleMake;
import com.samspringproject.VehicleApp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	// Returns List of countries
	public Iterable<VehicleMake> getVehicleMakes(){
		return vehicleMakeRepository.findAll();
		
	}
	
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	public Optional<VehicleMake> findById(int id) {
		
		return vehicleMakeRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleMakeRepository.deleteById(id);
	}


}
