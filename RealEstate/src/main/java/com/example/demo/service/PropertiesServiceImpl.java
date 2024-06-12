package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Properties;
import com.example.demo.repository.PropertiesRepository;

@Service
public class PropertiesServiceImpl implements PropertiesService {
    @Autowired
	private PropertiesRepository propertiesRepository;
	@Override
	public Properties savePropertiesInfo(Properties properties) {
		// TODO Auto-generated method stub
		return propertiesRepository.save(properties);
	}

	@Override
	public List<Properties> getAllPropertiesInfo() {
		// TODO Auto-generated method stub
		return propertiesRepository.findAll();
	}

	@Override
	public Properties getPropertiesById(int id) {
		// TODO Auto-generated method stub
		return propertiesRepository.findById(id).orElseThrow();
	}
	
	@Override
	public String deletePropertiesById(int id) {
		// TODO Auto-generated method stub
		propertiesRepository.deleteById(id);
		return "Property deleted.";
	}

	@Override
	public Properties updateProperties(int id, Properties properties) {
		// TODO Auto-generated method stub
		
		Properties p1 = propertiesRepository.findById(id).get();
		p1.setPName(properties.getPName());
		p1.setPType(properties.getPType());
		p1.setPAddress(properties.getPAddress());
		p1.setPDesc(properties.getPDesc());
		p1.setAdmin(properties.getAdmin());
		p1.setCustomer(properties.getCustomer());
		p1.setDeveloper(properties.getDeveloper());
		return propertiesRepository.save(p1);
	}
	


}
