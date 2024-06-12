package com.example.demo.utitity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Customer;
import com.example.demo.model.CustomerDTO;

@Component

public class CustomerConverter {
	public Customer convertToCustomerEntity(CustomerDTO customerDTO)
	{
		Customer customer=new Customer();
		if(customerDTO!=null)
		{
			BeanUtils.copyProperties(customerDTO, customer);
		}
		return customer;
	}
	
	//Convert Entity to DTO
	public CustomerDTO convertToCustomerDTO(Customer  customer)
	{
		CustomerDTO customerDTO=new CustomerDTO();
		if(customer!=null)
		{
			BeanUtils.copyProperties(customer, customerDTO);
		}
		return customerDTO;
	}

}
