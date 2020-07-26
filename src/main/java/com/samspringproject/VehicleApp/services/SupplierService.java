package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.Supplier;
import com.samspringproject.VehicleApp.repositories.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	
	// Returns List of countries
	public List<Supplier> getSupplier(){
		return supplierRepository.findAll();
		
	}
	
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	public Optional<Supplier> findById(int id) {
		
		return supplierRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		supplierRepository.deleteById(id);
	}


}
