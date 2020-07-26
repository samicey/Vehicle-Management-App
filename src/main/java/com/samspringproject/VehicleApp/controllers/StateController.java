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

import com.samspringproject.VehicleApp.models.States;
import com.samspringproject.VehicleApp.services.CountryService;
import com.samspringproject.VehicleApp.services.StateService;

@Controller
public class StateController {
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	
	//Get All States
	@GetMapping("state")
	public String findAll(Model model){		
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("countries", countryService.getCountries());
		return "state";
	}	
	
	@RequestMapping("state/findById") 
	@ResponseBody
	public Optional<States> findById(Integer id)
	{
		return stateService.findById(id);
	}
	
	//Add State
	@PostMapping(value="state/addNew")
	public String addNew(States state) {
		stateService.save(state);
		return "redirect:/state";
	}	
	
	@RequestMapping(value="state/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(States state) {
		stateService.save(state);
		return "redirect:/state";
	}
	
	@RequestMapping(value="state/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		stateService.delete(id);
		return "redirect:/state";
	}
}
