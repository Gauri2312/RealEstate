package com.example.demo.utitity;

import org.springframework.beans.BeanUtils;

import com.example.demo.entities.Developer;
import com.example.demo.model.DeveloperDTO;



public class DeveloperConverter {
	public Developer convertToDeveloperEntity(DeveloperDTO developerDTO)
	{
		Developer developer=new Developer();
		if(developerDTO!=null)
		{
			BeanUtils.copyProperties(developerDTO, developer);
		}
		return developer;
	}
	
	//Convert Entity to DTO
	public DeveloperDTO convertToDeveloperDTO(Developer  developer)
	{
		DeveloperDTO developerDTO=new DeveloperDTO();
		if(developer!=null)
		{
			BeanUtils.copyProperties(developer, developerDTO);
		}
		return developerDTO;
	}

}
