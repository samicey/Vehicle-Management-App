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

import com.samspringproject.VehicleApp.models.Vehicle;
import com.samspringproject.VehicleApp.services.ClientsService;
import com.samspringproject.VehicleApp.services.EmployeeService;
import com.samspringproject.VehicleApp.services.LocationService;
import com.samspringproject.VehicleApp.services.VehicleMakeService;
import com.samspringproject.VehicleApp.services.VehicleModelService;
import com.samspringproject.VehicleApp.services.VehicleService;
import com.samspringproject.VehicleApp.services.VehicleStatusService;
import com.samspringproject.VehicleApp.services.VehicleTypeService;

@Controller
public class VehicleController {
	
	   @Autowired private VehicleService vehicleService;
	   @Autowired private EmployeeService employeeService;
	   @Autowired private LocationService locationService;
	   @Autowired private VehicleMakeService vehicleMakeService;
	   @Autowired private VehicleStatusService vehicleStatusService;
	   @Autowired private VehicleTypeService vehicleTypeService;
	   @Autowired private VehicleModelService vehicleModelService;
		
		//Get All Vehicles
		@GetMapping("vehicle")
		public String findAll(Model model){		
			model.addAttribute("vehicles", vehicleService.getVehicles());
		    model.addAttribute("employees", employeeService.getEmployee());
			model.addAttribute("locations", locationService.getLocations());
			model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
			model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuss());
			model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
			model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
			return "vehicle";
		}	
		
		@RequestMapping("vehicles/findById") 
		@ResponseBody
		public Optional<Vehicle> findById(Integer id)
		{
			return vehicleService.findById(id);
		}
		
		//Add Vehicle
		@PostMapping(value="vehicles/addNew")
		public String addNew(Vehicle vehicle) {
			vehicleService.save(vehicle);
			return "redirect:/vehicle";
		}	
		
		@RequestMapping(value="vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
		public String update(Vehicle vehicle) {
			vehicleService.save(vehicle);
			return "redirect:/vehicle";
		}
		
		@RequestMapping(value="vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
		public String delete(Integer id) {
			vehicleService.delete(id);
			return "redirect:/vehicle";
		}
}
