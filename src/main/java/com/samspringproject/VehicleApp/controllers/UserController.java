package com.samspringproject.VehicleApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.samspringproject.VehicleApp.models.User;
import com.samspringproject.VehicleApp.services.UserService;

@Controller
public class UserController {
	
	@Autowired UserService userService;
	
	@GetMapping("/user")
	public String getUser() {
		return "user";
	}
	
	@PostMapping(value="user/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);
		RedirectView redirectView = new RedirectView("/login", true);
		redir.addFlashAttribute("message", 
				"You successfully registered!! You can now login");
		
		return redirectView;
	}
}
