package com.example.veteriner.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
	public class AnimalUpdateRequest {
		Long id;
		String petName;
		int petAge;
		String description;
		long kindId;
		long genusId;
	}


