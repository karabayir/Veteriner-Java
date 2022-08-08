package com.example.veteriner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.veteriner.model.Animal;
import com.example.veteriner.model.Genus;
import com.example.veteriner.model.Kind;
import com.example.veteriner.model.Owner;
import com.example.veteriner.repository.AnimalRepository;
import com.example.veteriner.requests.AnimalCreateRequest;
import com.example.veteriner.requests.AnimalUpdateRequest;

@Service
public class AnimalService {
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	OwnerService ownerService;
	
	@Autowired
	KindService kindService;
	
	@Autowired
	GenusService genusService;
	
	public List<Animal> getAllAnimals(){
		return animalRepository.findAll();
	}
	
	
	public Animal createAnimal(AnimalCreateRequest newAnimalCreateRequest) {
		Owner owner = ownerService.findOwnerById(newAnimalCreateRequest.getOwnerId());
		Kind kind= kindService.findKindById(newAnimalCreateRequest.getKindId());
		Genus genus = genusService.findGenusById(newAnimalCreateRequest.getGenusId());
		if(owner==null) {
			return null;
		}
		Animal toSave = new Animal();
		toSave.setId(newAnimalCreateRequest.getId());
		toSave.setPetName(newAnimalCreateRequest.getPetName());
		toSave.setPetAge(newAnimalCreateRequest.getPetAge());
		toSave.setDescription(newAnimalCreateRequest.getDescription());
		toSave.setOwner(owner);
		toSave.setKind(kind);
		toSave.setGenus(genus);
		return animalRepository.save(toSave);
	}
	
	public Animal updateAnimal(long id , AnimalUpdateRequest newAnimalUpdateRequest) {
		Animal animalUpdate = animalRepository.findById(id).orElse(null);
		Kind kind=kindService.findKindById(newAnimalUpdateRequest.getKindId());
		Genus genus = genusService.findGenusById(newAnimalUpdateRequest.getGenusId());
		if(animalUpdate==null)
			return null;
		animalUpdate.setPetName(newAnimalUpdateRequest.getPetName());
		animalUpdate.setPetAge(newAnimalUpdateRequest.getPetAge());
		animalUpdate.setDescription(newAnimalUpdateRequest.getDescription());
		animalUpdate.setKind(kind);
		animalUpdate.setGenus(genus);
		return animalRepository.save(animalUpdate);
	}
	
	
	public Animal findByName(String petName) {
		return animalRepository.findByPetName(petName);
	}
	
	public void deleteAnimalById(long id) {
		 animalRepository.deleteById(id);
	}
	
	
	
}
