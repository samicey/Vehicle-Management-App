package com.samspringproject.VehicleApp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samspringproject.VehicleApp.models.Clients;
import com.samspringproject.VehicleApp.services.CountryService;
import com.samspringproject.VehicleApp.services.ClientsService;
import com.samspringproject.VehicleApp.services.StateService;

@Controller
public class ClientsController {
	
	@Autowired private ClientsService clientsService;
	@Autowired private CountryService countryService;
	@Autowired private StateService  stateService;
	
	//Get All Clients
	@GetMapping("clients")
	public String findAll(Model model){		
		model.addAttribute("clients", clientsService.getClients());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "clients";
	}	
	
	@RequestMapping("clients/findById") 
	@ResponseBody
	public Optional<Clients> findById(Integer id)
	{
		return clientsService.findById(id);
	}
	
	//Add Clients
	@PostMapping(value="clients/addNew")
	public String addNew(Clients clients) {
		clientsService.save(clients);
		return "redirect:/clients";
	}	
	
	@RequestMapping(value="clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Clients clients) {
		clientsService.save(clients);
		return "redirect:/clients";
	}
	
	@RequestMapping(value="clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		clientsService.delete(id);
		return "redirect:/clients";
	}
}
