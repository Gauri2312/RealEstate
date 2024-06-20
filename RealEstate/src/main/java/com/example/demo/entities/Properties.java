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
	@Column(name="propertyId",length=20)
	private int pId;
	@Column(name="propertyName",length=30)
	private String pName;
	@Column(name="propertyType",length=30)
	private String pType;
	@Column(name="propertyAddress",length=40)
	private String pAddress;
	@Column(name="propertyDesc",length=60)
	private String pDesc;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="developerId")
	private Developer developer;
	
	@ManyToOne
	@JoinColumn(name="adminId")
	private Admin admin;
	

}
