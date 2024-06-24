package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Properties;
import com.example.demo.model.PropertiesDTO;
import com.example.demo.repository.PropertiesRepository;
import com.example.demo.utitity.PropertiesConverter;

@Service
public class PropertiesServiceImpl implements PropertiesService {
    @Autowired
	private PropertiesRepository propertiesRepository;
    
    @Autowired
    PropertiesConverter propertiesconverter;
    
	@Override
	public PropertiesDTO createProperties(Properties properties) {
		// TODO Auto-generated method stub
		Properties p= propertiesRepository.save(properties);
		return propertiesconverter.convertToPropertiesDTO(p);
	}

	@Override
	public List<PropertiesDTO> getAllPropertiesInfo() {
		// TODO Auto-generated method stub
		List<Properties> properties= propertiesRepository.findAll();
		List<PropertiesDTO> dtos=new ArrayList<>();
		for(Properties p:properties)
		{
			dtos.add(propertiesconverter.convertToPropertiesDTO(p));
		}
		
		
		return dtos;
	}

	@Override
	public PropertiesDTO getPropertiesById(int id) {
		// TODO Auto-generated method stub
		Properties pro= propertiesRepository.findById(id).get();
		return propertiesconverter.convertToPropertiesDTO(pro);
	}
	
	@Override
	public String deletePropertiesById(int id) {
		// TODO Auto-generated method stub
		propertiesRepository.deleteById(id);
		return "Property deleted.";
	}

	@Override
	public PropertiesDTO updateProperties(int id, Properties properties) {
		// TODO Auto-generated method stub
		
		Properties p1 = propertiesRepository.findById(id).get();
		p1.setPname(properties.getPname());
		p1.setPtype(properties.getPtype());
		p1.setPaddress(properties.getPaddress());
		p1.setPdesc(properties.getPdesc());
		p1.setAdmin(properties.getAdmin());
		p1.setCustomer(properties.getCustomer());
		p1.setDeveloper(properties.getDeveloper());
		Properties prop= propertiesRepository.save(p1);
		return propertiesconverter.convertToPropertiesDTO(prop);
	}
	


}
