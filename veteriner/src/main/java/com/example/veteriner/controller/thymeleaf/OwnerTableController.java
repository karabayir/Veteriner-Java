package com.example.veteriner.controller.thymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.veteriner.model.Owner;
import com.example.veteriner.service.OwnerService;

@Controller
public class OwnerTableController {
	
	OwnerService ownerService;

	public OwnerTableController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@GetMapping("/owner")
	public String getOwnersTh(Model model) {
		List<Owner> ownerList = ownerService.getAllOwners();
		model.addAttribute("ownerList", ownerList);
		return "owner";
	}
}
