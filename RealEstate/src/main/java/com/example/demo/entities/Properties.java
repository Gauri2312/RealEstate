package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Properties {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pId;
	@Column(name="propertyName")
	private String pName;
	private String pType;
	private String pAddress;
	private String pDesc;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="d_id")
	private Developer developer;
	
	@ManyToOne
	@JoinColumn(name="a_id")
	private Admin admin;
	

}
