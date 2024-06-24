package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.model.AdminDTO;
import com.example.demo.repository.AdminRepository;
import com.example.demo.utitity.AdminConverter;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
	private AdminRepository adminRepository;
    @Autowired
    AdminConverter adminconverter;
	@Override
	public AdminDTO createAdmin(Admin admin) {
		// TODO Auto-generated method stub
	  Admin adm= adminRepository.save(admin);
	  return adminconverter.convertToAdminDTO(adm);
	}

	@Override
	public List<AdminDTO> getAllAdminInfo() {
		// TODO Auto-generated method stub
		List<Admin> admin= adminRepository.findAll();
		List<AdminDTO> dtos=new ArrayList<>();
		for(Admin a:admin)
		{
			dtos.add(adminconverter.convertToAdminDTO(a));
		}
		
		
		return dtos;
	}

	@Override
	public AdminDTO getAdminById(int id) {
		// TODO Auto-generated method stub
		Admin a = adminRepository.findById(id).get();
		return adminconverter.convertToAdminDTO(a);
	}

	@Override
	public String deleteAdminById(int id) {
		// TODO Auto-generated method stub
				adminRepository.deleteById(id);
				return "Admin deleted.";
	}

	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		
		Admin a1 = adminRepository.findById(id).get();
		a1.setAname(admin.getAname());
		a1.setAemail(admin.getAemail());
		a1.setApassword(admin.getApassword());
		a1.setDeveloper(admin.getDeveloper());
		a1.setProperties(admin.getProperties());
		
		Admin adm=adminRepository.save(a1);
		return adminconverter.convertToAdminDTO(adm);
	}
	
	
}
