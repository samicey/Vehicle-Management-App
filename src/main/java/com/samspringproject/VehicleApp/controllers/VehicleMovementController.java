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

import com.samspringproject.VehicleApp.models.VehicleMovement;
import com.samspringproject.VehicleApp.services.LocationService;
import com.samspringproject.VehicleApp.services.SupplierService;
import com.samspringproject.VehicleApp.services.VehicleMovementService;
import com.samspringproject.VehicleApp.services.VehicleService;

@Controller
public class VehicleMovementController {
	
	@Autowired private VehicleMovementService vehicleMovementService;
	@Autowired private LocationService locationService;
	@Autowired private VehicleService vehicleService;
	
	//Get All VehicleMovement
	@GetMapping("vehicleMovement")
	public String findAll(Model model){		
		model.addAttribute("vehicleMovement", vehicleMovementService.getVehicleMovement());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("locations", locationService.getLocations());
		return "vehicleMovement";
	}	
	
	@RequestMapping("vehicleMovement/findById") 
	@ResponseBody
	public Optional<VehicleMovement> findById(Integer id)
	{
		return vehicleMovementService.findById(id);
	}
	
	//Add VehicleMovement
	@PostMapping(value="vehicleMovement/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
	}	
	
	@RequestMapping(value="vehicleMovement/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
	}
	
	@RequestMapping(value="vehicleMovement/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovement";
	}
}
