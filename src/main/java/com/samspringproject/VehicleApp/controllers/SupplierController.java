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

import com.samspringproject.VehicleApp.models.Supplier;
import com.samspringproject.VehicleApp.services.CountryService;
import com.samspringproject.VehicleApp.services.StateService;
import com.samspringproject.VehicleApp.services.SupplierService;
@Controller
public class SupplierController {

@Autowired private StateService stateService;
@Autowired private CountryService countryService;
@Autowired private SupplierService supplierService;

//Get All Supplier
@GetMapping("supplier")
public String findAll(Model model){		
	model.addAttribute("supplier", supplierService.getSupplier());
	model.addAttribute("countries", countryService.getCountries());
	model.addAttribute("states", stateService.getStates());
	
	return "supplier";
}	

@RequestMapping("supplier/findById") 
@ResponseBody
public Optional<Supplier> findById(Integer id)
{
	return supplierService.findById(id);
}

//Add Supplier
@PostMapping(value="supplier/addNew")
public String addNew(Supplier supplier) {
	supplierService.save(supplier);
	return "redirect:/supplier";
}	

@RequestMapping(value="supplier/update", method = {RequestMethod.PUT, RequestMethod.GET})
public String update(Supplier supplier) {
	supplierService.save(supplier);
	return "redirect:/supplier";
}

@RequestMapping(value="supplier/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
public String delete(Integer id) {
	supplierService.delete(id);
	return "redirect:/supplier";
}
}