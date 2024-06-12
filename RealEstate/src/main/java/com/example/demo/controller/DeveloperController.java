package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Developer;
import com.example.demo.model.DeveloperDTO;
import com.example.demo.service.DeveloperService;
import com.example.demo.utitity.DeveloperConverter;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
	@Autowired
	private DeveloperService developerService;
	
	@Autowired
	DeveloperConverter developerconverter;
	
	@PostMapping("/createDeveloper")
	ResponseEntity<DeveloperDTO> createDeveloper(@RequestBody DeveloperDTO developerDto) {
		final Developer developer=developerconverter.convertToDeveloperEntity(developerDto);
		return new ResponseEntity<DeveloperDTO>(developerService.createDeveloper(developer),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAllDeveloper")
	public List<DeveloperDTO> getAllDeveloperInfo(){
		return developerService.getAllDeveloperInfo();
	}
	
	@GetMapping("/getDeveloperById/{did}")
	public DeveloperDTO getDeveloperById(@PathVariable("did") int id) {
		return developerService.getDeveloperById(id);
	}
	
	@DeleteMapping("/deleteDeveloperById/{did}")
	public String deleteDeveloperById(@PathVariable("did") int id)
	{
		developerService.deleteDeveloperById(id);
		return "Developer deleted.";
		
	}
	
	@PutMapping("/updateDeveloper/{did}")
	public DeveloperDTO updateDeveloper(@PathVariable("did") int id, @RequestBody Developer developer) {
		return developerService.updateDeveloper(id, developer);
		
	}

}
