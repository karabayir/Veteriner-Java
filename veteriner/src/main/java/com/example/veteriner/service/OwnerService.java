package com.example.veteriner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.veteriner.model.Owner;
import com.example.veteriner.repository.OwnerRepository;

@Service
public class OwnerService {

	 private final OwnerRepository ownerRepository;
	 
	
	public OwnerService(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	public List<Owner> getAllOwners(){
		return ownerRepository.findAll();
	}
	
	public Owner findOwnerById(long ownerId) {
	   return ownerRepository.findById(ownerId).orElse(null);
	}
	
	public Owner findByName(String ownerName) {
		return ownerRepository.findByOwnerName(ownerName);
	}
	
	public Owner createOwner(Owner newOwner) {
		return ownerRepository.save(newOwner);
	}
	
	public Owner updateOwner(long ownerId,Owner newOwner) {
		Owner updateOwner= ownerRepository.findById(ownerId).orElse(null);
		updateOwner.setOwnerName(newOwner.getOwnerName());
		updateOwner.setOwnerSurname(newOwner.getOwnerSurname());
		updateOwner.setOwnerMailAddress(newOwner.getOwnerMailAddress());
		updateOwner.setOwnerPhone(newOwner.getOwnerPhone());
		ownerRepository.save(updateOwner);
		return updateOwner;
	}
	
	public void deleteOwner(long id) {
		ownerRepository.deleteById(id);
	}
	
}
