package com.example.veteriner.requests;

import lombok.Data;

@Data
	public class AnimalUpdateRequest {
		Long id;
		String petName;
		int petAge;
		String description;
		long kindId;
		long genusId;
	}


