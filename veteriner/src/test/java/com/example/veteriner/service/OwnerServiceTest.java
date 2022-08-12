package com.example.veteriner.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.veteriner.model.Owner;
import com.example.veteriner.repository.OwnerRepository;

public class OwnerServiceTest {
	
	private OwnerService ownerService;
	
	private OwnerRepository ownerRepository;

	@Before
	public void setUp() throws Exception {
		ownerRepository = Mockito.mock(OwnerRepository.class);
		ownerService=new OwnerService(ownerRepository);
	}
	
	@Test
	public void whenCreateOwnerCalledWithValidRequest_itShouldReturnValidOwner() {
		Owner owner = new Owner(10,"tunahan","test","5447498328","muhriphan@outlook.com");
		Mockito.when(ownerService.createOwner(owner)).thenReturn(owner);
		Owner result = ownerService.createOwner(owner);
		
		Assert.assertEquals(result, owner);
		Mockito.verify(ownerRepository).save(owner);
	}
	
}
