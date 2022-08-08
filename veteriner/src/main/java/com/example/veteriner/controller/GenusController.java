package com.example.veteriner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.veteriner.model.Genus;
import com.example.veteriner.service.GenusService;

@RestController
@RequestMapping("/genus")
public class GenusController {
	
	@Autowired
	GenusService genusService;
	
	@GetMapping
	public List<Genus> getAllGenus(){
		return genusService.getAllGenus();
	}
	
	@PostMapping
	public Genus createGenus(@RequestBody Genus newGenus) {
		return genusService.createGenus(newGenus);
	}
	
	@PutMapping("/{id}")
	public Genus updateGenus(@PathVariable long id,@RequestBody Genus newGenus) {
		return genusService.updateGenus(id, newGenus);
	}
}
