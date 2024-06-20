package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Developer;
import com.example.demo.model.DeveloperDTO;
import com.example.demo.repository.DeveloperRepository;
import com.example.demo.utitity.DeveloperConverter;

@Service
public class DeveloperServiceImpl implements DeveloperService{
    @Autowired
	private DeveloperRepository developerRepository;
    
    @Autowired
    DeveloperConverter developerconverter;
	
	@Override
	public DeveloperDTO createDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		Developer d= developerRepository.save(developer);
		return developerconverter.convertToDeveloperDTO(d);
	}

	@Override
	public List<DeveloperDTO> getAllDeveloperInfo() {
		// TODO Auto-generated method stub
		List<Developer> developer= developerRepository.findAll();
		List<DeveloperDTO> dtos=new ArrayList<>();
		for(Developer d:developer)
		{
			dtos.add(developerconverter.convertToDeveloperDTO(d));
		}
		
		return dtos;
	}

	@Override
	public DeveloperDTO getDeveloperById(int id) {
		// TODO Auto-generated method stub
		Developer d= developerRepository.findById(id).get();
		return developerconverter.convertToDeveloperDTO(d);
		
	}
	

	@Override
	public String deleteDeveloperById(int id) {
		// TODO Auto-generated method stub
		developerRepository.deleteById(id);
				return "Developer deleted.";
	}

	@Override
	public DeveloperDTO updateDeveloper(int id, Developer developer) {
		// TODO Auto-generated method stub
		
		Developer d1 = developerRepository.findById(id).get();
		d1.setDName(developer.getDName());
		d1.setDEmail(developer.getDEmail());
		d1.setDPassword(developer.getDPassword());
		d1.setDCity(developer.getDCity());
		d1.setDContact(developer.getDContact());
		d1.setProperties(developer.getProperties());
		d1.setFaq(developer.getFaq());
		Developer dev= developerRepository.save(d1);
		return developerconverter.convertToDeveloperDTO(dev);
	}
	
	

}
