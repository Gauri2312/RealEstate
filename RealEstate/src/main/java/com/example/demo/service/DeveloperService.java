package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Developer;

public interface DeveloperService {
	
	public Developer saveDeveloperInfo(Developer developer);
	public List<Developer> getAllDeveloperInfo();
	public Developer getDeveloperById(int id);
	public String deleteDeveloperById(int id);
	public Developer updateDeveloper(int id, Developer developer);

}
