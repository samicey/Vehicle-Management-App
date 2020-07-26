package com.samspringproject.VehicleApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.EmployeeType;
import com.samspringproject.VehicleApp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	// Returns List of countries
	public Iterable<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
		
	}
	
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	public Optional<EmployeeType> findById(int id) {
		
		return employeeTypeRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeTypeRepository.deleteById(id);
	}


}
