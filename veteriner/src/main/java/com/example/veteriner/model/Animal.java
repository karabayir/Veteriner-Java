package com.example.veteriner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	private String petName;
	private int petAge;
	private String description;
	
	
	@ManyToOne()
	@JsonIgnore
	Owner owner;

	
	@OneToOne()
	Kind kind;
	
	@OneToOne()
	Genus genus;

	
	
	
}
