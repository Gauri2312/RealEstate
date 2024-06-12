package com.example.demo.utitity;

import org.springframework.beans.BeanUtils;

import com.example.demo.entities.Properties;
import com.example.demo.model.PropertiesDTO;


public class PropertiesConverter {
	public Properties convertToPropertiesEntity(PropertiesDTO propertiesDTO)
	{
		Properties properties=new Properties();
		if(propertiesDTO!=null)
		{
			BeanUtils.copyProperties(propertiesDTO, properties);
		}
		return properties;
	}
	
	//Convert Entity to DTO
	public PropertiesDTO convertToPropertiesDTO(Properties  properties)
	{
		PropertiesDTO propertiesDTO=new PropertiesDTO();
		if(properties!=null)
		{
			BeanUtils.copyProperties(properties, propertiesDTO);
		}
		return propertiesDTO;
	}

}
