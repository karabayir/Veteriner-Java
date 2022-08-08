package com.example.veteriner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.veteriner.model.Animal;
import com.example.veteriner.requests.AnimalCreateRequest;
import com.example.veteriner.requests.AnimalUpdateRequest;
import com.example.veteriner.service.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalController {

	@Autowired
	AnimalService animalService;
	
	@GetMapping()
	public List<Animal> getAllAnimals(){
		return animalService.getAllAnimals();
	}
	
	@GetMapping("/{petName}")
	public Animal findByName(@PathVariable String petName) {
		return animalService.findByName(petName);
	}
	
	@PostMapping()
	public Animal createAnimal(@RequestBody AnimalCreateRequest newAnimalCreateRequest) {
		return animalService.createAnimal(newAnimalCreateRequest);
	}
	@PutMapping("/{id}")
	public Animal updateAnimal(@PathVariable long id ,@RequestBody AnimalUpdateRequest animalUpdateRequest) {
		return animalService.updateAnimal(id, animalUpdateRequest);
	}
	@DeleteMapping("/{id}")
	public void deleteAnimalById(@PathVariable long id) {
		animalService.deleteAnimalById(id);
	}
}
