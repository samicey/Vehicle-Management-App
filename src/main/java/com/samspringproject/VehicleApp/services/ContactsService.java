package com.samspringproject.VehicleApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.Contact;
import com.samspringproject.VehicleApp.repositories.ContactRepository;

@Service
public class ContactsService {
	@Autowired
	private ContactRepository contactRepository;
	
	// Returns List of countries
	public List<Contact> getContacts(){
		return contactRepository.findAll();
		
	}
	
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
	
	public Optional<Contact> findById(int id) {
		
		return contactRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
	}


}
