package com.samspringproject.VehicleApp.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samspringproject.VehicleApp.services.EmployeeService;
@Controller
public class ProfileController {
	
	@Autowired private EmployeeService employeeService;
	
	@RequestMapping("/profile")
	public String profile(Model model, Principal principal) {
		
		String in = principal.getName();
		model.addAttribute("employee",employeeService.findByUsername(in));
		
		return "profile";
	}

}
