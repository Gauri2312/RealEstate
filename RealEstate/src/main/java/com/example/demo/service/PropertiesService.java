package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Properties;

public interface PropertiesService {
	public Properties savePropertiesInfo(Properties properties);
	public List<Properties> getAllPropertiesInfo();
	public Properties getPropertiesById(int id);
	public String deletePropertiesById(int id);
	public Properties updateProperties(int id, Properties properties);

}
