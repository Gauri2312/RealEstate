package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	@NotNull
	private int cId;
	@NotBlank
	@Size(min = 2, max = 20, message= "Customer Name should contains only 2 to 20 characters")
	private String cName;
	@NotBlank
	@Size(min = 2, max = 10, message= "Customer Mob no. should contains only 10 numbers")
	private long cMobNo;
	@NotBlank
	@Size(min = 2, max = 20, message= "Customer Email should contains only 2 to 20 characters")
	private String cEmail;
	@NotBlank
	@Size(min = 2, max = 20, message= "Customer Password should contains only 2 to 20 characters")
	private String cPassword;
	@NotBlank
	@Size(min = 2, max = 20, message= "Customer City should contains only 2 to 20 characters")
	private String cCity;

}
