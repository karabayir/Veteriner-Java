package com.example.veteriner.controller.thymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.veteriner.model.Genus;
import com.example.veteriner.model.Kind;
import com.example.veteriner.model.Owner;      
import com.example.veteriner.requests.AnimalUpdateRequest;
import com.example.veteriner.service.AnimalService;

import com.example.veteriner.service.GenusService;
import com.example.veteriner.service.KindService;
import com.example.veteriner.service.OwnerService;

@Controller
public class AnimalUpdateController {
	
	
	KindService kindService;
	GenusService genusService;
	OwnerService ownerService;
	AnimalService animalService;
	
	public AnimalUpdateController(KindService kindService, GenusService genusService, OwnerService ownerService , AnimalService animalService) {
		this.kindService = kindService;
		this.genusService = genusService;
		this.ownerService = ownerService;
		this.animalService=animalService;
	}

    @GetMapping("/animal-update")
	public String animalUpdateGet(Model model , AnimalUpdateRequest animal) {
		List<Kind> kindList = kindService.getAllKinds();
		List<Genus> genusList=genusService.getAllGenus();
		List<Owner> ownerList=ownerService.getAllOwners();
		model.addAttribute("kindList", kindList);
		model.addAttribute("genusList", genusList);
		model.addAttribute("ownerList", ownerList);
		model.addAttribute("animal", animal);
		return "animal-update";
	}
    
   @PostMapping("/animal-update/{id}")
    public String animalUpdatePost(long id , BindingResult result,Model model,AnimalUpdateRequest animal) {
    	animalService.updateAnimal(id, animal);
    	return "redirect:/";
    }
    

}
