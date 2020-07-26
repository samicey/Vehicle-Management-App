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

import com.samspringproject.VehicleApp.models.VehicleMaintenance;
import com.samspringproject.VehicleApp.services.SupplierService;
import com.samspringproject.VehicleApp.services.VehicleMaintenanceService;
import com.samspringproject.VehicleApp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
		
	@Autowired private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired private SupplierService supplierService;
	@Autowired private VehicleService vehicleService;
	
	//Get All VehicleMaintenance
	@GetMapping("vehicleMaintenance")
	public String findAll(Model model){		
		model.addAttribute("vehicleMaintenance", vehicleMaintenanceService.getVehicleMaintenance());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("suppliers", supplierService.getSupplier());
		return "vehicleMaintenance";
	}	
	
	@RequestMapping("vehicleMaintenance/findById") 
	@ResponseBody
	public Optional<VehicleMaintenance> findById(Integer id)
	{
		return vehicleMaintenanceService.findById(id);
	}
	
	//Add VehicleMaintenance
	@PostMapping(value="vehicleMaintenance/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}	
	
	@RequestMapping(value="vehicleMaintenance/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}
	
	@RequestMapping(value="vehicleMaintenance/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenance";
	}

}
