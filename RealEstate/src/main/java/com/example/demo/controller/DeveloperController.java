package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Developer;
import com.example.demo.service.DeveloperService;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
	@Autowired
	private DeveloperService developerService;
	
	@PostMapping("/add")
	public String add(@RequestBody Developer developer) {
		developerService.saveDeveloperInfo(developer);
		return "Developer Info Added.";
	}
	
	@GetMapping("/getAllDeveloper")
	public List<Developer> getAllDeveloperInfo(){
		return developerService.getAllDeveloperInfo();
	}
	
	@GetMapping("/getDeveloperById/{did}")
	public Developer getDeveloperById(@PathVariable("did") int id) {
		return developerService.getDeveloperById(id);
	}
	
	@DeleteMapping("/deleteDeveloperById/{did}")
	public String deleteDeveloperById(@PathVariable("did") int id)
	{
		developerService.deleteDeveloperById(id);
		return "Developer deleted.";
		
	}
	
	@PutMapping("/updateDeveloper/{did}")
	public Developer updateDeveloper(@PathVariable("did") int id, @RequestBody Developer developer) {
		return developerService.updateDeveloper(id, developer);
		
	}

}
