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

import com.example.veteriner.model.Owner;
import com.example.veteriner.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@GetMapping()
	public List<Owner> getAllOwner(){
		return ownerService.getAllOwners();
	}
	
	/*@GetMapping("/{id}")
	public Owner findOwnerById(@PathVariable long id) {
		return ownerService.findOwnerById(id);
	}*/
	
	@GetMapping("/{ownerName}")
	public Owner findByName(@PathVariable String ownerName) {
		return ownerService.findByName(ownerName);
	}
	
	@PostMapping()
	public Owner createOwner(@RequestBody Owner newOwner) {
		return ownerService.createOwner(newOwner);
	}
	
	@PutMapping("/{ownerId}")
	public Owner updateOwner(@PathVariable long ownerId ,@RequestBody Owner newOwner) {
		return ownerService.updateOwner(ownerId, newOwner);
	}
	
	@DeleteMapping("/{ownerId}")
	public void deleteOwner(@PathVariable long ownerId) {
		 ownerService.deleteOwner(ownerId);
	}
	
}
