package com.example.veteriner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.veteriner.model.Genus;
import com.example.veteriner.repository.GenusRepository;

@Service
public class GenusService {
	
	@Autowired
	GenusRepository genusRepository;
	
	public List<Genus> getAllGenus(){
		return genusRepository.findAll();
	}
	
	public Genus findGenusById(long GenusId) {
		return genusRepository.findById(GenusId).orElse(null);
	}
	
	public Genus createGenus(Genus newGenus) {
		return genusRepository.save(newGenus);
	}
	
	public Genus updateGenus(long id , Genus newGenus) {
		Genus updateGenus = genusRepository.findById(id).orElse(null);
		if(updateGenus == null)
			return null;
		updateGenus.setGenusName(newGenus.getGenusName());
		genusRepository.save(updateGenus);
		return updateGenus;
	}
}
