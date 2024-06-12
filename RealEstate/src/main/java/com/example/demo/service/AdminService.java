package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Admin;

public interface AdminService {
	public Admin saveAdminInfo(Admin admin);
	public List<Admin> getAllAdminInfo();
	public Admin getAdminById(int id);
	public String deleteAdminById(int id);
	public Admin updateAdmin(int id, Admin admin);

}
