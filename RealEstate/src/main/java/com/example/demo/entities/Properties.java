package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
	private int pid;
	@Column(name="propertyName",length=30)
	private String pname;
	@Column(name="propertyType",length=30)
	private String ptype;
	@Column(name="propertyAddress",length=40)
	private String paddress;
	@Column(name="propertyDesc",length=60)
	private String pdesc;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customerId")
	@JsonIgnoreProperties("properties")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="developerId")
	@JsonIgnoreProperties("properties")
	private Developer developer;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="adminId")
	@JsonIgnoreProperties("properties")
	private Admin admin;
	

}
