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

import com.samspringproject.VehicleApp.models.VehicleHire;
import com.samspringproject.VehicleApp.services.ClientsService;
import com.samspringproject.VehicleApp.services.LocationService;
import com.samspringproject.VehicleApp.services.VehicleHireService;

@Controller
public class VehicleHireController {
	
   @Autowired private VehicleHireService vehicleHireService;
   @Autowired private ClientsService clientsService;
   @Autowired private LocationService locationService;
	
	//Get All VehicleHires
	@GetMapping("vehicleHire")
	public String findAll(Model model){		
		model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
		model.addAttribute("clients", clientsService.getClients());
		model.addAttribute("locations", locationService.getLocations());
		return "vehicleHire";
	}	
	
	@RequestMapping("vehicleHire/findById") 
	@ResponseBody
	public Optional<VehicleHire> findById(Integer id)
	{
		return vehicleHireService.findById(id);
	}
	
	//Add VehicleHire
	@PostMapping(value="vehicleHire/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}	
	
	@RequestMapping(value="vehicleHire/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}
	
	@RequestMapping(value="vehicleHire/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehicleHire";
	}
}
