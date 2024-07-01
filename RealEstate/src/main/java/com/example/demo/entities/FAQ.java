package com.example.demo.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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

@SuppressWarnings("deprecation")
@Entity
@SQLDelete(sql="UPDATE faq SET status=true  where enquiry_id=?")
@Where(clause = "status=false")
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
	
	private boolean status=Boolean.FALSE;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customerId")
	@JsonIgnoreProperties("faq")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="developerId")
	@JsonIgnoreProperties("faq")
	private Developer developer;
	
	

	
}
