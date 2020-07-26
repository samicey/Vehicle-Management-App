package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.VehicleMaintenance;
import com.samspringproject.VehicleApp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {
	
	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	// Returns List of countries
	public List<VehicleMaintenance> getVehicleMaintenance(){
		return vehicleMaintenanceRepository.findAll();
		
	}
	
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	public Optional<VehicleMaintenance> findById(int id) {
		
		return vehicleMaintenanceRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleMaintenanceRepository.deleteById(id);
	}

}
