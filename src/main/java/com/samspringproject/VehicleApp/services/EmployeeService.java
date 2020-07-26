package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.Employee;
import com.samspringproject.VehicleApp.repositories.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Returns List of countries
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
		
	}
	
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Optional<Employee> findById(int id) {
		
		return employeeRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	public Employee findByUsername(String in) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUsername(in);
	}


}
