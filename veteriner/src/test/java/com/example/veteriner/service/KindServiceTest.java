package com.example.veteriner.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.veteriner.model.Kind;
import com.example.veteriner.repository.KindRepository;


public class KindServiceTest {
	
	private KindService kindService;
	private KindRepository kindRepository;

	@Before
	public void setUp() throws Exception {
		kindRepository=Mockito.mock(KindRepository.class);
		kindService=new KindService(kindRepository);
	}

	@Test
	public void whenCreateKindCalledWithValidRequest_itShouldReturnValidKind() {
		
		Kind kind = new Kind(10,"Balık");
		Mockito.when(kindService.createKind(kind)).thenReturn(kind);
		
		Kind result = kindService.createKind(kind);
		Assert.assertEquals(result, kind);
		Mockito.verify(kindRepository).save(kind);
	}

}
