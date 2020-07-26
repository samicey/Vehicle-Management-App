package com.samspringproject.VehicleApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.InvoiceStatus;
import com.samspringproject.VehicleApp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	// Returns List of countries
	public Iterable<InvoiceStatus> getInvoiceStatuss(){
		return invoiceStatusRepository.findAll();
		
	}
	
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	public Optional<InvoiceStatus> findById(int id) {
		
		return invoiceStatusRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		invoiceStatusRepository.deleteById(id);
	}


}
