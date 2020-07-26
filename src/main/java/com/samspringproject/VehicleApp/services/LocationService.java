package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.Location;
import com.samspringproject.VehicleApp.repositories.LocationRepository;

@Service
public class LocationService {
	

	@Autowired
	private LocationRepository locationRepository;
	
	// Returns List of countries
	public Iterable<Location> getLocations(){
		return locationRepository.findAll();
		
	}
	
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	public Optional<Location> findById(int id) {
		
		return locationRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		locationRepository.deleteById(id);
	}


}
