package com.example.demo.model;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Developer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertiesDTO {
	@NotNull
	private int pId;
	@NotBlank
	@Size(min = 2, max = 30, message= "Property Name should contains only 2 to 20 characters")
	private String pName;
	@NotBlank
	@Size(min = 2, max = 30, message= "Property type should contains only 2 to 20 characters")
	private String pType;
	@NotBlank
	@Size(min = 2, max = 40, message= "Property Address should contains only 2 to 20 characters")
	private String pAddress;
	@NotBlank
	@Size(min = 2, max = 60, message= "Property Description should contains only 2 to 20 characters")
	private String pDesc;

	private Customer customer;
	
	private Developer developer;
	
	private Admin admin;
}
