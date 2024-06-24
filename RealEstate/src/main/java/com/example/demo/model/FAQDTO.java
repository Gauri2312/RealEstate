package com.example.demo.model;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Developer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FAQDTO {
	@NotNull
	private int eid;
	@NotBlank
	@Size(min = 2, max = 20, message= "Enquirer Name should contains only 2 to 20 characters")
	private String ename;
	@NotBlank
	@Column(unique = true)
	@Size(min=10, max=10, message= "Enquirer Mob no. should contains only 10 numbers" )
	private String emobno;
	@NotBlank
	@Size(min = 2, max = 40, message= "Enquirer msg should contains only 2 to 20 characters")
	private String emsg;
	
	private Customer customer;
	
	private Developer developer;
	

}
