package com.example.demo.utitity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Admin;
import com.example.demo.model.AdminDTO;

@Component

public class AdminConverter {
	public Admin convertToAdminEntity(AdminDTO adminDTO)
	{
		Admin admin=new Admin();
		if(adminDTO!=null)
		{
			BeanUtils.copyProperties(adminDTO, admin);
		}
		return admin;
	}
	
	//Convert Entity to DTO
	public AdminDTO convertToAdminDTO(Admin admin)
	{
		AdminDTO adminDTO=new AdminDTO();
		if(admin!=null)
		{
			BeanUtils.copyProperties(admin, adminDTO);
		}
		return adminDTO;
	}

}
