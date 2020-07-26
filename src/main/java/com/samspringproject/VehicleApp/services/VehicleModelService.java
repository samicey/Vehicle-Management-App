package com.samspringproject.VehicleApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.VehicleModel;
import com.samspringproject.VehicleApp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	// Returns List of countries
	public Iterable<VehicleModel> getVehicleModels(){
		return vehicleModelRepository.findAll();
		
	}
	
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
	public Optional<VehicleModel> findById(int id) {
		
		return vehicleModelRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleModelRepository.deleteById(id);
	}


}
