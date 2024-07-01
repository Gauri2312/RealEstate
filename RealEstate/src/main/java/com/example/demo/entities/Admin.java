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
@SQLDelete(sql="UPDATE admin SET status=true  where admin_id=?")
@Where(clause = "status=false")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adminId",length=20)
	private int aid;
	@Column(name="adminName",length=20)
	private String aname;
	@Column(name="adminEmail",length=20)
	private String aemail;
	@Column(name="adminPassword",length=20)
	private String apassword;
	
	private boolean status=Boolean.FALSE;
	
	@OneToMany(mappedBy = "admin")
	@JsonIgnoreProperties("admin")
    List<Developer> developer;
	
	@OneToMany(mappedBy = "admin")
	@JsonIgnoreProperties("admin")
    List<Properties> properties;
	
	

	

}
