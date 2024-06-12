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
	@Column(name="enquiry_id")
	private int eId;
	private String eName;
	private long eMobNo;
	private String eMsg;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="d_id")
	private Developer developer;
	
	

	
}
