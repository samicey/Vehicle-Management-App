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

import com.samspringproject.VehicleApp.models.Location;
import com.samspringproject.VehicleApp.models.States;
import com.samspringproject.VehicleApp.services.CountryService;
import com.samspringproject.VehicleApp.services.StateService;
import com.samspringproject.VehicleApp.services.LocationService;

@Controller
public class LocationController {
	
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	@Autowired private LocationService locationService;
	
	//Get All Locations
	@GetMapping("location")
	public String findAll(Model model){		
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "location";
	}	
	
	@RequestMapping("locations/findById") 
	@ResponseBody
	public Optional<Location> findById(Integer id)
	{
		return locationService.findById(id);
	}
	
	//Add Location
	@PostMapping(value="locations/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}	
	
	@RequestMapping(value="locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	
	@RequestMapping(value="locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		locationService.delete(id);
		return "redirect:/location";
	}
}
