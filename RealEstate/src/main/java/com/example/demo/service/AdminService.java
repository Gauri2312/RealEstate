package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Admin;
import com.example.demo.model.AdminDTO;

public interface AdminService {
	public AdminDTO createAdmin(Admin admin);
	public List<AdminDTO> getAllAdminInfo();
	public AdminDTO getAdminById(int id);
	public String deleteAdminById(int id);
	public AdminDTO updateAdmin(int id, Admin admin);

}
