package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Customer;
import com.example.demo.model.CustomerDTO;

public interface CustomerService {
	public CustomerDTO createCustomer(Customer customer);
	public List<CustomerDTO> getAllCustomerInfo();
	public CustomerDTO getCustomerById(int id);
	public String deleteCustomerById(int id);
	public CustomerDTO updateCustomer(int id, Customer customer);

}
