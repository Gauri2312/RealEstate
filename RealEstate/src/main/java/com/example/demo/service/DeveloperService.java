package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Developer;
import com.example.demo.model.DeveloperDTO;

public interface DeveloperService {
	
	public DeveloperDTO createDeveloper(Developer developer);
	public List<DeveloperDTO> getAllDeveloperInfo();
	public DeveloperDTO getDeveloperById(int id);
	public String deleteDeveloperById(int id);
	public DeveloperDTO updateDeveloper(int id, Developer developer);

}
