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

import com.samspringproject.VehicleApp.models.VehicleStatus;
import com.samspringproject.VehicleApp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	
	
	@Autowired private VehicleStatusService vehicleStatusService;
	
	//Get All VehicleStatuss
	@GetMapping("vehicleStatus")
	public String findAll(Model model){		
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuss());
		return "vehicleStatus";
	}	
	
	@RequestMapping("vehicleStatus/findById") 
	@ResponseBody
	public Optional<VehicleStatus> findById(Integer id)
	{
		return vehicleStatusService.findById(id);
	}
	
	//Add VehicleStatus
	@PostMapping(value="vehicleStatus/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}	
	
	@RequestMapping(value="vehicleStatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}
	
	@RequestMapping(value="vehicleStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatus";
	}
}
