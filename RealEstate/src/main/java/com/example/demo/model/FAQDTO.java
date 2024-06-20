package com.example.demo.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FAQDTO {
	@NotNull
	private int eId;
	@NotBlank
	@Size(min = 2, max = 20, message= "Enquirer Name should contains only 2 to 20 characters")
	private String eName;
	@NotBlank
	@Size(min = 2, max = 10, message= "Enquirer Mob no. should contains only 10 numbers")
	private long eMobNo;
	@NotBlank
	@Size(min = 2, max = 40, message= "Enquirer msg should contains only 2 to 20 characters")
	private String eMsg;
	

}
