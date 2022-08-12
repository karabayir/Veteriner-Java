package com.example.veteriner.requests;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalCreateRequest {

	Long id;
	
	String petName;
	int petAge;
	String description;
	long kindId;
	String kindName;
	long genusId;
	String genusName;
	long ownerId;
	String ownerName;
	
}
