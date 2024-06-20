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
	@Column(name="developerId",length=20)
	private int dId;
	@Column(name="developerName",length=20)
	private String dName;
	@Column(name="developerContact",length=10)
	private long dContact;
	@Column(name="developerEmail",length=20)
	private String dEmail;
	@Column(name="developerPassword",length=20)
	private String dPassword;
	@Column(name="developerCity",length=20)
	private String dCity;
	
	@OneToMany(mappedBy = "developer",cascade = CascadeType.ALL)
	private List<FAQ> faq=new ArrayList<FAQ>();
	
	@OneToMany(mappedBy = "developer",cascade = CascadeType.ALL)
	private List<Properties> properties=new ArrayList<Properties>();
	
	@ManyToOne
	@JoinColumn(name="adminId")
	private Admin admin;
	

	
}
