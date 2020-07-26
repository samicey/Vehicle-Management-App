package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.States;
import com.samspringproject.VehicleApp.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	// Returns List of countries
	public List<States> getStates(){
		return stateRepository.findAll();
		
	}
	
	public void save(States state) {
		stateRepository.save(state);
	}
	
	public Optional<States> findById(int id) {
		
		return stateRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		stateRepository.deleteById(id);
	}

}
