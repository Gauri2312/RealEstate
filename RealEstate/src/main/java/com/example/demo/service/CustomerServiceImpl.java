package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
	private CustomerRepository customerRepository;
    
	@Override
	public Customer saveCustomerInfo(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomerInfo() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).orElseThrow();
	}

	@Override
	public String deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		 customerRepository.deleteById(id);
		 return "Customer deleted.";
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub
		
		Customer c1=customerRepository.findById(id).get();
		c1.setCName(customer.getCName());
		c1.setCMobNo(customer.getCMobNo());
		c1.setCEmail(customer.getCEmail());
		c1.setCPassword(customer.getCPassword());
		c1.setCCity(customer.getCCity());
		
		return customerRepository.save(c1);
	}

}
