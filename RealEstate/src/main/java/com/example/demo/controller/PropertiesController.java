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

import com.example.demo.entities.Properties;
import com.example.demo.service.PropertiesService;

@RestController
@RequestMapping("/properties")
public class PropertiesController {
	@Autowired
	private PropertiesService propertiesService;
	
	@PostMapping("/add")
	public String add(@RequestBody Properties properties) {
		propertiesService.savePropertiesInfo(properties);
		return "Properties Info Added.";
	}
	
	@GetMapping("/getAll")
	public List<Properties> getAllPropertiesInfo(){
		return propertiesService.getAllPropertiesInfo();
	}
	
	@GetMapping("/getPropertiesById/{pid}")
	public Properties getPropertiesById(@PathVariable("pid") int id) {
		return propertiesService.getPropertiesById(id);
	}
	
	@DeleteMapping("/deletePropertiesById/{pid}")
	public String deletePropertiesById(@PathVariable("pid") int id)
	{
		propertiesService.deletePropertiesById(id);
		return "Properties deleted.";
		
	}
	
	@PutMapping("/updateProperties/{pid}")
	public Properties updateProperties(@PathVariable("pid") int id, @RequestBody Properties properties) {
		return propertiesService.updateProperties(id, properties);
		
	}


}
