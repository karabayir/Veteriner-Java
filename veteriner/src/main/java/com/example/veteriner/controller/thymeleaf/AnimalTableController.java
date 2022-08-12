package com.example.veteriner.controller.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.veteriner.model.Animal;
import com.example.veteriner.service.AnimalService;


@Controller
public class AnimalTableController {
	
	
	private final AnimalService animalService;
	
	public AnimalTableController(AnimalService animalService) {
		this.animalService = animalService;
	}



	@GetMapping("/animal")
	public String getAnimalsTh(Model model) {
		List<Animal> animalList = animalService.getAllAnimals();
		model.addAttribute("animalList", animalList);
		return "animal";
	}
	
	
}
