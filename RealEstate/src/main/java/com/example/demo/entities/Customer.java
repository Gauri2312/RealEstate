package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_id")
	private int cId;
	private String cName;
	private long cMobNo;
	private String cEmail;
	private String cPassword;
	private String cCity;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Properties> properties=new ArrayList<Properties>();
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<FAQ> faq=new ArrayList<FAQ>();

	
	

}
