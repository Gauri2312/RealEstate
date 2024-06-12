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
public class FAQ {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enquiryId",length=20)
	private int eId;
	@Column(name="enquiryName",length=30)
	private String eName;
	@Column(name="enquiryMobNo",length=20)
	private long eMobNo;
	@Column(name="enquiryMsg",length=60)
	private String eMsg;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="d_id")
	private Developer developer;
	
	

	
}
