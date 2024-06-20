package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Properties;
import com.example.demo.model.PropertiesDTO;
import com.example.demo.service.PropertiesService;
import com.example.demo.utitity.PropertiesConverter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/properties")
@Validated
public class PropertiesController {
	@Autowired
	private PropertiesService propertiesService;
	
	@Autowired
	PropertiesConverter propertiesconverter;
	
	@PostMapping("/createProperties")
	ResponseEntity<PropertiesDTO> createProperties(@Valid @RequestBody PropertiesDTO propertiesDto) {
		final Properties properties=propertiesconverter.convertToPropertiesEntity(propertiesDto);
		return new ResponseEntity<PropertiesDTO>(propertiesService.createProperties(properties),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllProperties")
	public List<PropertiesDTO> getAllPropertiesInfo(){
		return propertiesService.getAllPropertiesInfo();
	}
	
	@GetMapping("/getPropertiesById/{pid}")
	public PropertiesDTO getPropertiesById(@PathVariable("pid") int id) {
		return propertiesService.getPropertiesById(id);
	}
	
	@DeleteMapping("/deletePropertiesById/{pid}")
	public String deletePropertiesById(@PathVariable("pid") int id)
	{
		propertiesService.deletePropertiesById(id);
		return "Properties deleted.";
		
	}
	
	@PutMapping("/updateProperties/{pid}")
	public PropertiesDTO updateProperties(@PathVariable("pid") int id, @RequestBody Properties properties) {
		return propertiesService.updateProperties(id, properties);
		
	}


}
