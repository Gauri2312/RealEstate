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
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adminId",length=20)
	private int aId;
	@Column(name="adminName",length=40)
	private String aName;
	@Column(name="adminEmail",length=30)
	private String aEmail;
	@Column(name="adminPassword",length=30)
	private String aPassword;
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	private List<Developer> developer=new ArrayList<Developer>();
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	private List<Properties> properties=new ArrayList<Properties>();
	
	

	

}
