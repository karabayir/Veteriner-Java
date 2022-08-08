package com.example.veteriner.requests;

import lombok.Data;

@Data
public class AnimalCreateRequest {

	Long id;
	String petName;
	int petAge;
	String description;
	long kindId;
	long genusId;
	long ownerId;
	
}
