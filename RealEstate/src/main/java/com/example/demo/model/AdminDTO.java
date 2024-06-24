package com.example.demo.model;

import java.util.List;

import com.example.demo.entities.Developer;
import com.example.demo.entities.Properties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
	@NotNull
	private int aid;
	@NotBlank
	@Size(min = 2, max = 20, message= "Admin Name should contains only 2 to 20 characters")
	private String aname;
	@NotBlank
	@Size(min = 2, max = 20, message= "Admin Email should contains only 2 to 20 characters")
	private String aemail;
	@NotBlank
	@Size(min = 2, max = 20, message= "Admin Password should contains only 2 to 20 characters")
	private String apassword;
	
	 List<Developer> developer;
	 
	 List<Properties> properties;

}
