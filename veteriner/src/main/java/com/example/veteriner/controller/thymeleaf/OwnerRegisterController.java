package com.example.veteriner.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.veteriner.model.Owner;
import com.example.veteriner.service.OwnerService;

@Controller
public class OwnerRegisterController {
	
	OwnerService ownerService;

	public OwnerRegisterController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@GetMapping("/owner-register")
	public String ownerRegisterGet(Model model , Owner owner ) {
		model.addAttribute("owner", owner);
		return "owner-register";
	}
	
	@PostMapping("/owner-register")
	public String ownerRegisterPost(Owner owner ,BindingResult result , Model model) {
		ownerService.createOwner(owner);
		return "redirect:/";
	}
}
