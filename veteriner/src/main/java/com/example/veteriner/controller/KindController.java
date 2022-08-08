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

import com.example.veteriner.model.Kind;
import com.example.veteriner.service.KindService;

@RestController
@RequestMapping("/kinds")
public class KindController {
	
	@Autowired
	KindService kindService;
	
	@GetMapping()
	public List<Kind> getAllKinds(){
		return kindService.getAllKinds();
	}
	
	@PostMapping()
	public Kind createKind(@RequestBody Kind newKind) {
		return kindService.createKind(newKind);
	}
	
	@PutMapping("/{id}")
	public Kind updateKind(@PathVariable long id ,@RequestBody Kind newKind) {
		return kindService.updateKind(id, newKind);
	}
}
