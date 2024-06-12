package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Properties;
import com.example.demo.model.PropertiesDTO;

public interface PropertiesService {
	public PropertiesDTO createProperties(Properties properties);
	public List<PropertiesDTO> getAllPropertiesInfo();
	public PropertiesDTO getPropertiesById(int id);
	public String deletePropertiesById(int id);
	public PropertiesDTO updateProperties(int id, Properties properties);

}
