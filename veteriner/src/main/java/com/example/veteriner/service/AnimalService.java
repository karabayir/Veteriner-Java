package com.example.veteriner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.veteriner.model.Animal;
import com.example.veteriner.model.Genus;
import com.example.veteriner.model.Kind;
import com.example.veteriner.model.Owner;
import com.example.veteriner.repository.AnimalRepository;
import com.example.veteriner.requests.AnimalCreateRequest;
import com.example.veteriner.requests.AnimalUpdateRequest;

@Service
public class AnimalService {
	
	private final AnimalRepository animalRepository;
	private final OwnerService ownerService;
	private final KindService kindService;
	private final GenusService genusService;
	
	
	
	public AnimalService(AnimalRepository animalRepository, OwnerService ownerService, KindService kindService,
		GenusService genusService) {
		this.animalRepository = animalRepository;
		this.ownerService = ownerService;
		this.kindService = kindService;
		this.genusService = genusService;
	}


	public List<Animal> getAllAnimals(){
		 List<Animal> animalList= animalRepository.findAll();
		 return animalList;
	}
	
	public Animal findAnimalById(long id) {
		return animalRepository.findById(id).orElse(null);
	}
	
	
	public Animal saveAnimal(Animal animal) {
		return animalRepository.save(animal);
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
