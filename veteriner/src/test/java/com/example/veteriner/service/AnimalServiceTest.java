package com.example.veteriner.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.veteriner.model.Animal;
import com.example.veteriner.model.Genus;
import com.example.veteriner.model.Kind;
import com.example.veteriner.model.Owner;
import com.example.veteriner.repository.AnimalRepository;
import com.example.veteriner.repository.OwnerRepository;
import com.example.veteriner.requests.AnimalCreateRequest;

public class AnimalServiceTest {
	
	private AnimalService animalService;
	private AnimalRepository animalRepository;
	private OwnerService ownerService;
	private KindService kindService;
	private GenusService genusService;
	
	
	@Before
	public void setUp() throws Exception {
		animalRepository = Mockito.mock(AnimalRepository.class);
		ownerService=Mockito.mock(OwnerService.class);
		kindService=Mockito.mock(KindService.class);
		genusService=Mockito.mock(GenusService.class);
		animalService= new AnimalService(animalRepository, ownerService, kindService, genusService);
	}

	@Test
	public void whenCreateAnimalCalledWithValidRequest_itShuoldReturnValidAnimal() {
		Owner owner = new Owner(1,"tunahan","karabayır","12345", "12345@mail.com");
		Kind kind = new Kind(1, "Süper Balık");
		Genus genus = new Genus(1, "lol");
		Animal animal = new Animal(10, "Fizz", 2, "beslenme zamanı", owner, kind, genus);
		AnimalCreateRequest animalCreateRequest = new AnimalCreateRequest(
				animal.getId(), 
				animal.getPetName(),
				animal.getPetAge(), 
				animal.getDescription(),
				kind.getId(), 
				kind.getKindName(),
				genus.getId(),
				genus.getGenusName(),
				owner.getId(),
				owner.getOwnerName());
		Mockito.when(ownerService.findOwnerById(1)).thenReturn(owner);
		Mockito.when(kindService.findKindById(1)).thenReturn(kind);
		Mockito.when(genusService.findGenusById(1)).thenReturn(genus);
		Mockito.when(animalService.createAnimal(animalCreateRequest)).thenReturn(animal);
		
		Animal result = animalService.saveAnimal(animal);
		Assert.assertEquals(result, animal);
		Mockito.verify(animalRepository).save(animal);
	}

}
