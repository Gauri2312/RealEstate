package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Customer;

public interface CustomerService {
	public Customer saveCustomerInfo(Customer customer);
	public List<Customer> getAllCustomerInfo();
	public Customer getCustomerById(int id);
	public String deleteCustomerById(int id);
	public Customer updateCustomer(int id, Customer customer);

}
