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

import com.example.demo.entities.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public String add(@RequestBody Customer customer) {
		customerService.saveCustomerInfo(customer);
		return "Customer Info added.";
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomerInfo(){
		return customerService.getAllCustomerInfo();
	}
	
	@GetMapping("/getCustomerById/{cid}")
	public Customer getCustomerById(@PathVariable("cid") int id) {
		return customerService.getCustomerById(id);
	}
	
	@DeleteMapping("/deleteCustomerById/{cid}")
	public String deleteCustomerById(@PathVariable("cid") int id)
	{
		customerService.deleteCustomerById(id);
		return "Customer deleted.";
		
	}
	
	@PutMapping("/updateCustomer/{cid}")
	public Customer updateCustomer(@PathVariable("cid") int id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
		
	}

}
