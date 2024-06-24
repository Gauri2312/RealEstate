package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private int did;
	@Column(name="developerName",length=20)
	private String dname;
	@Column(name="developerContact",length=10)
	private String dcontact;
	@Column(name="developerEmail",length=20)
	private String demail;
	@Column(name="developerPassword",length=20)
	private String dpassword;
	@Column(name="developerCity",length=20)
	private String dcity;
	
	@OneToMany(mappedBy = "developer")
	@JsonIgnoreProperties("developer")
    List<FAQ> faq;
	
	@OneToMany(mappedBy = "developer")
	@JsonIgnoreProperties("developer")
	List<Properties> properties;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="adminId")
	@JsonIgnoreProperties("developer")
	private Admin admin;
	

	
}
