package com.example.veteriner.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.veteriner.model.Genus;
import com.example.veteriner.repository.GenusRepository;

public class GenusServiceTest {
	
	private GenusRepository genusRepository;
	private GenusService genusService;
	
	@Before
	public void setUp() throws Exception {
		genusRepository=Mockito.mock(GenusRepository.class);
		genusService= new GenusService(genusRepository);
	    
	}

	@Test
	public void whenCreateGenusCalledWithValidRequest_itShouldReturnValidGenus() {
		
		Genus genus = new Genus(10,"Alabalık");
		Mockito.when(genusService.createGenus(genus)).thenReturn(genus);
		
		Genus result = genusService.createGenus(genus);
		Assert.assertEquals(result, genus);
		Mockito.verify(genusRepository).save(genus);
	}

}
