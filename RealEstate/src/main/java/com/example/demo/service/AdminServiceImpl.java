package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin saveAdminInfo(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdminInfo() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return  adminRepository.findById(id).orElseThrow();
	}

	@Override
	public String deleteAdminById(int id) {
		// TODO Auto-generated method stub
				adminRepository.deleteById(id);
				return "Admin deleted.";
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		
		Admin a1 = adminRepository.findById(id).get();
		a1.setAName(admin.getAName());
		a1.setAEmail(admin.getAEmail());
		a1.setAPassword(admin.getAPassword());
		a1.setDeveloper(admin.getDeveloper());
		a1.setProperties(admin.getProperties());
		return adminRepository.save(a1);
	}
	
	
}
