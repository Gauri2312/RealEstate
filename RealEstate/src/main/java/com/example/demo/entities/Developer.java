package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Developer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dId;
	@Column(name="developerName")
	private String dName;
	private long dContact;
	private String dEmail;
	private String dPassword;
	private String dCity;
	
	@OneToMany(mappedBy = "developer",cascade = CascadeType.ALL)
	private List<FAQ> faq=new ArrayList<FAQ>();
	
	@OneToMany(mappedBy = "developer",cascade = CascadeType.ALL)
	private List<Properties> properties=new ArrayList<Properties>();
	
	@ManyToOne
	@JoinColumn(name="a_id")
	private Admin admin;
	

	
}
