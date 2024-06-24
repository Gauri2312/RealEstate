package com.example.demo.model;

import java.util.List;

import com.example.demo.entities.FAQ;
import com.example.demo.entities.Properties;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	@NotNull
	private int cid;
	@NotBlank
	@Size(min = 2, max = 20, message= "Customer Name should contains only 2 to 20 characters")
	private String cname;
	@NotBlank
	@Column(unique = true)
	@Size(min=10, max=10, message= "Customer Mob no. should contains only 10 numbers" )
	private String cmobno;
	@NotBlank
	@Size(min = 2, max = 20, message= "Customer Email should contains only 2 to 20 characters")
	private String cemail;
	@NotBlank
	@Size(min = 2, max = 20, message= "Customer Password should contains only 2 to 20 characters")
	private String cpassword;
	@NotBlank
	@Size(min = 2, max = 20, message= "Customer City should contains only 2 to 20 characters")
	private String ccity;
	
	  List<Properties> properties;
	  
	  List<FAQ> faq;

}
