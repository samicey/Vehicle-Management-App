package com.samspringproject.VehicleApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.VehicleType;
import com.samspringproject.VehicleApp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	// Returns List of countries
	public Iterable<VehicleType> getVehicleTypes(){
		return vehicleTypeRepository.findAll();
		
	}
	
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
	public Optional<VehicleType> findById(int id) {
		
		return vehicleTypeRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleTypeRepository.deleteById(id);
	}


}
