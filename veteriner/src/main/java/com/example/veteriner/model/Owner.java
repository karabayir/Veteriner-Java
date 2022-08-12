package com.example.veteriner.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	private String ownerName;
	private String ownerSurname;
	private String ownerPhone;
	private String ownerMailAddress;
	
	
	/*@OneToMany(mappedBy = "owner",fetch = FetchType.EAGER , cascade =CascadeType.ALL)
	List<Animal> ownerPetList = new ArrayList();*/


	

	


	
	
}


