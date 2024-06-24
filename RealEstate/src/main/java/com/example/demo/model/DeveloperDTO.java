package com.example.demo.model;
import java.util.List;

import com.example.demo.entities.Admin;
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

public class DeveloperDTO {
    @NotNull
	private int did;
    @NotBlank
	@Size(min = 2, max = 20, message= "Developer Name should contains only 2 to 20 characters")
	private String dname;
    @NotBlank
    @Column(unique = true)
    @Size(min=10, max=10, message= "Developer Mob no. should contains only 10 numbers" )
	private String dcontact;
    @NotBlank
	@Size(min = 2, max = 20, message= "Developer Email should contains only 2 to 20 characters")
	private String demail;
    @NotBlank
	@Size(min = 2, max = 20, message= "Developer Password should contains only 2 to 20 characters")
	private String dpassword;
    @NotBlank
	@Size(min = 2, max = 20, message= "Developer City should contains only 2 to 20 characters")
	private String dcity;
    
    List<FAQ> faq;
    
    List<Properties> properties;
    
    private Admin admin;
}
