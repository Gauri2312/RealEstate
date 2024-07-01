package com.example.demo.entities;

import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@SuppressWarnings("deprecation")
@Entity
@SQLDelete(sql="UPDATE customer SET status=true  where customer_id=?")
@Where(clause = "status=false")

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
	
	private boolean status=Boolean.FALSE; //customer is active in the system
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
    List<Properties> properties;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
    List<FAQ> faq;
	

}
