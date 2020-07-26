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

import com.samspringproject.VehicleApp.models.Employee;
import com.samspringproject.VehicleApp.services.EmployeeService;
import com.samspringproject.VehicleApp.services.EmployeeTypeService;
import com.samspringproject.VehicleApp.services.JobTitleService;
import com.samspringproject.VehicleApp.services.CountryService;
import com.samspringproject.VehicleApp.services.StateService;

@Controller
public class EmployeeController {
	

	@Autowired private EmployeeService employeeService;
	@Autowired private CountryService countryService;
	@Autowired private StateService  stateService;
	@Autowired private JobTitleService  jobTitleService;
	@Autowired private EmployeeTypeService  employeeTypeService;
	
	//Get All Employee
	@GetMapping("employee")
	public String findAll(Model model){		
		model.addAttribute("employees", employeeService.getEmployee());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		return "employee";
	}	
	
	@RequestMapping("employees/findById") 
	@ResponseBody
	public Optional<Employee> findById(Integer id)
	{
		return employeeService.findById(id);
	}
	
	//Add Employee
	@PostMapping(value="employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	}	
	
	@RequestMapping(value="employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	@RequestMapping(value="employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/employee";
	}
}
