package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.service.AdminService;
@RestController
@RequestMapping("/admin")
public class AdminController {
	
		@Autowired
		private AdminService adminService;
		
		@PostMapping("/add")
		public String add(@RequestBody Admin admin) {
			adminService.saveAdminInfo(admin);
			return "Admin Info added.";
		}
		
		@GetMapping("/getAll")
		public List<Admin> getAllAdminInfo(){
			return adminService.getAllAdminInfo();
		}
		
		@GetMapping("/getAdminById/{cid}")
		public Admin getAdminById(@PathVariable("aid") int id) {
			return adminService.getAdminById(id);
		}
		
		@DeleteMapping("/deleteAdminById/{aid}")
		public String deleteAdminById(@PathVariable("aid") int id)
		{
			adminService.deleteAdminById(id);
			return "Admin deleted.";
			
		}
		
		@PutMapping("/updateAdmin/{aid}")
		public Admin updateAdmin(@PathVariable("aid") int id, @RequestBody Admin admin) {
			return adminService.updateAdmin(id, admin);
			
		}
		

}
