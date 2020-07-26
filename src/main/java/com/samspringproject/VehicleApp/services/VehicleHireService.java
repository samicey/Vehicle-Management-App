package com.samspringproject.VehicleApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.VehicleHire;
import com.samspringproject.VehicleApp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	// Returns List of Vehicle Hire
	public Iterable<VehicleHire> getVehicleHires(){
		return vehicleHireRepository.findAll();
		
	}
	
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	public Optional<VehicleHire> findById(int id) {
		
		return vehicleHireRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleHireRepository.deleteById(id);
	}

}
