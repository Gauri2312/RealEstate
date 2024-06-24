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
public class FAQ {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enquiryId",length=20)
	private int eid;
	@Column(name="enquiryName",length=10)
	private String ename;
	@Column(name="enquiryMobNo",length=10)
	private String emobno;
	@Column(name="enquiryMsg",length=40)
	private String emsg;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customerId")
	@JsonIgnoreProperties("faq")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="developerId")
	@JsonIgnoreProperties("faq")
	private Developer developer;
	
	

	
}
