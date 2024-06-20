package com.example.demo.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DeveloperDTO {
    @NotNull
	private int dId;
    @NotBlank
	@Size(min = 2, max = 20, message= "Developer Name should contains only 2 to 20 characters")
	private String dName;
    @NotBlank
	@Size(min = 2, max = 10, message= "Developer Mob no. should contains only 10 numbers")
	private long dContact;
    @NotBlank
	@Size(min = 2, max = 20, message= "Developer Email should contains only 2 to 20 characters")
	private String dEmail;
    @NotBlank
	@Size(min = 2, max = 20, message= "Developer Password should contains only 2 to 20 characters")
	private String dPassword;
    @NotBlank
	@Size(min = 2, max = 20, message= "Developer City should contains only 2 to 20 characters")
	private String dCity;
}
