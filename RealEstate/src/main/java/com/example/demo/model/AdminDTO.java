package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
	@NotNull
	private int aId;
	@NotBlank
	@Size(min = 2, max = 20, message= "Admin Name should contains only 2 to 20 characters")
	private String aName;
	@NotBlank
	@Size(min = 2, max = 20, message= "Admin Email should contains only 2 to 20 characters")
	private String aEmail;
	@NotBlank
	@Size(min = 2, max = 20, message= "Admin Password should contains only 2 to 20 characters")
	private String aPassword;

}
