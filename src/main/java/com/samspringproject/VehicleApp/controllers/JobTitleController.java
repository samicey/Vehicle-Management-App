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

import com.samspringproject.VehicleApp.models.JobTitle;
import com.samspringproject.VehicleApp.services.JobTitleService;

@Controller
public class JobTitleController {
	
	@Autowired private JobTitleService jobTitleService;
	
	//Get All JobTitles
	@GetMapping("jobTitle")
	public String findAll(Model model){		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		return "jobTitle";
	}	
	
	@RequestMapping("jobTitle/findById") 
	@ResponseBody
	public Optional<JobTitle> findById(Integer id)
	{
		return jobTitleService.findById(id);
	}
	
	//Add JobTitle
	@PostMapping(value="jobTitle/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitle";
	}	
	
	@RequestMapping(value="jobTitle/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitle";
	}
	
	@RequestMapping(value="jobTitle/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		jobTitleService.delete(id);
		return "redirect:/jobTitle";
	}
}
