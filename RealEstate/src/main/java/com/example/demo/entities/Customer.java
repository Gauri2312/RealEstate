package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@Column(name="customerId",length=20)
	private int cid;
	@Column(name="customerName",length=20)
	private String cname;
	@Column(name="customerMobNo",length=10)
	private String cmobno;
	@Column(name="customerEmail",length=20)
	private String cemail;
	@Column(name="customerPassword",length=20)
	private String cpassword;
	@Column(name="customerCity",length=20)
	private String ccity;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
    List<Properties> properties;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
    List<FAQ> faq;
	

}
