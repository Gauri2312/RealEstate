package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.model.CustomerDTO;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.utitity.CustomerConverter;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
	private CustomerRepository customerRepository;
    
    @Autowired
    CustomerConverter customerconverter;
    
	@Override
	public CustomerDTO createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer c= customerRepository.save(customer);
		return customerconverter.convertToCustomerDTO(c);
	}

	@Override
	public List<CustomerDTO> getAllCustomerInfo() {
		// TODO Auto-generated method stub
		List<Customer> customer= customerRepository.findAll();
		List<CustomerDTO> dtos= new ArrayList<>();
		for(Customer c:customer)
		{
			dtos.add(customerconverter.convertToCustomerDTO(c));
		}
		
		
		return dtos;
	}

	@Override
	public CustomerDTO getCustomerById(int id) {
		// TODO Auto-generated method stub
		Customer c= customerRepository.findById(id).get();
		return customerconverter.convertToCustomerDTO(c);
	}

	@Override
	public String deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		 customerRepository.deleteById(id);
		 return "Customer deleted.";
	}

	@Override
	public CustomerDTO updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub
		
		Customer c1=customerRepository.findById(id).get();
		c1.setCName(customer.getCName());
		c1.setCMobNo(customer.getCMobNo());
		c1.setCEmail(customer.getCEmail());
		c1.setCPassword(customer.getCPassword());
		c1.setCCity(customer.getCCity());
		
		Customer cust= customerRepository.save(c1);
		return customerconverter.convertToCustomerDTO(cust);
	}

}
