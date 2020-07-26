package com.samspringproject.VehicleApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samspringproject.VehicleApp.models.JobTitle;
import com.samspringproject.VehicleApp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	// Returns List of countries
	public Iterable<JobTitle> getJobTitles(){
		return jobTitleRepository.findAll();
		
	}
	
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
	
	public Optional<JobTitle> findById(int id) {
		
		return jobTitleRepository.findById(id);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		jobTitleRepository.deleteById(id);
	}


}
