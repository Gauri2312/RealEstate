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

import com.example.demo.entities.Customer;
import com.example.demo.model.CustomerDTO;
import com.example.demo.service.CustomerService;
import com.example.demo.utitity.CustomerConverter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	CustomerConverter customerconverter;
	
	@PostMapping("/createCustomer")
    ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDto) {
		final Customer customer=customerconverter.convertToCustomerEntity(customerDto);
		return new ResponseEntity<CustomerDTO>(customerService.createCustomer(customer),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAllCustomer")
	public List<CustomerDTO> getAllCustomerInfo(){
		return customerService.getAllCustomerInfo();
	}
	
	@GetMapping("/getCustomerById/{cid}")
	public CustomerDTO getCustomerById(@PathVariable("cid") int id) {
		return customerService.getCustomerById(id);
	}
	
	@DeleteMapping("/deleteCustomerById/{cid}")
	public String deleteCustomerById(@PathVariable("cid") int id)
	{
		customerService.deleteCustomerById(id);
		return "Customer deleted.";
		
	}
	
	@PutMapping("/updateCustomer/{cid}")
	public CustomerDTO updateCustomer(@PathVariable("cid") int id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
		
	}

}
