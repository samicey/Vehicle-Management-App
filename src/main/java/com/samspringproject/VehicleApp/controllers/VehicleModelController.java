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

import com.samspringproject.VehicleApp.models.VehicleModel;
import com.samspringproject.VehicleApp.services.VehicleModelService;

@Controller
public class VehicleModelController {
	
	@Autowired private VehicleModelService vehicleModelService;
	
	//Get All VehicleModels
	@GetMapping("vehicleModel")
	public String findAll(Model model){		
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		return "vehicleModel";
	}	
	
	@RequestMapping("vehicleModel/findById") 
	@ResponseBody
	public Optional<VehicleModel> findById(Integer id)
	{
		return vehicleModelService.findById(id);
	}
	
	//Add VehicleModel
	@PostMapping(value="vehicleModel/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModel";
	}	
	
	@RequestMapping(value="vehicleModel/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModel";
	}
	
	@RequestMapping(value="vehicleModel/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleModelService.delete(id);
		return "redirect:/vehicleModel";
	}
}
