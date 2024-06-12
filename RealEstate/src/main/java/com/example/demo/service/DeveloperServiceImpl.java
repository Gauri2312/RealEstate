package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Developer;
import com.example.demo.repository.DeveloperRepository;

@Service
public class DeveloperServiceImpl implements DeveloperService{
    @Autowired
	private DeveloperRepository developerRepository;
	
	@Override
	public Developer saveDeveloperInfo(Developer developer) {
		// TODO Auto-generated method stub
		return developerRepository.save(developer);
	}

	@Override
	public List<Developer> getAllDeveloperInfo() {
		// TODO Auto-generated method stub
		return developerRepository.findAll();
	}

	@Override
	public Developer getDeveloperById(int id) {
		// TODO Auto-generated method stub
		return developerRepository.findById(id).orElseThrow();
	}
	

	@Override
	public String deleteDeveloperById(int id) {
		// TODO Auto-generated method stub
		developerRepository.deleteById(id);
				return "Developer deleted.";
	}

	@Override
	public Developer updateDeveloper(int id, Developer developer) {
		// TODO Auto-generated method stub
		
		Developer d1 = developerRepository.findById(id).get();
		d1.setDName(developer.getDName());
		d1.setDEmail(developer.getDEmail());
		d1.setDPassword(developer.getDPassword());
		d1.setDCity(developer.getDCity());
		d1.setDContact(developer.getDContact());
		d1.setProperties(developer.getProperties());
		d1.setFaq(developer.getFaq());
		return developerRepository.save(d1);
	}
	
	

}
