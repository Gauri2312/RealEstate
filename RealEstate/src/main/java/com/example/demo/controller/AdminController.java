package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.model.AdminDTO;
import com.example.demo.service.AdminService;
import com.example.demo.utitity.AdminConverter;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
	
		@Autowired
		private AdminService adminService;
		
		@Autowired
		AdminConverter adminconverter;
		
		@PostMapping("/createAdmin")
		 ResponseEntity<AdminDTO> createAdmin(@Valid @RequestBody AdminDTO adminDto) {
			final Admin admin=adminconverter.convertToAdminEntity(adminDto);
			return new ResponseEntity<AdminDTO>(adminService.createAdmin(admin),HttpStatus.CREATED);
		}
		
		@GetMapping("/getAllAdmins")
		public List<AdminDTO> getAllAdminInfo(){
			return adminService.getAllAdminInfo();
		}
		
		@GetMapping("/getAdminById/{cid}")
		public AdminDTO getAdminById(@PathVariable("aid") int id) {
			return adminService.getAdminById(id);
		}
		
		@DeleteMapping("/deleteAdminById/{aid}")
		public String deleteAdminById(@PathVariable("aid") int id)
		{
			adminService.deleteAdminById(id);
			return "Admin deleted.";
			
		}
		
		@PutMapping("/updateAdmin/{aid}")
		public AdminDTO updateAdmin(@PathVariable("aid") int id, @RequestBody Admin admin) {
			return adminService.updateAdmin(id, admin);
			
		}
		

}
