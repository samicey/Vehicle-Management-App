package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.Invoice;
import com.samspringproject.VehicleApp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	// Returns List of countries
	public List<Invoice> getInvoices(){
		return invoiceRepository.findAll();
		
	}
	
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	public Optional<Invoice> findById(int id) {
		
		return invoiceRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		invoiceRepository.deleteById(id);
	}

}
