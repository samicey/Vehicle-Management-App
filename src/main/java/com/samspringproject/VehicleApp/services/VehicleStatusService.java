package com.samspringproject.VehicleApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.VehicleStatus;
import com.samspringproject.VehicleApp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	// Returns List of countries
	public Iterable<VehicleStatus> getVehicleStatuss(){
		return vehicleStatusRepository.findAll();
		
	}
	
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}
	
	public Optional<VehicleStatus> findById(int id) {
		
		return vehicleStatusRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleStatusRepository.deleteById(id);
	}


}
