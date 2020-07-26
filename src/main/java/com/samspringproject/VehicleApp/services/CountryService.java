package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.Country;
import com.samspringproject.VehicleApp.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	// Returns List of countries
	public List<Country> getCountries(){
		return countryRepository.findAll();
		
	}
	
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	public Optional<Country> findById(int id) {
		
		return countryRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		countryRepository.deleteById(id);
	}

}
