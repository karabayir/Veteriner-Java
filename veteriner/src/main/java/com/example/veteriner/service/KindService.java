package com.example.veteriner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.veteriner.model.Kind;
import com.example.veteriner.repository.KindRepository;

@Service
public class KindService {
	
	@Autowired
	KindRepository kindRepository;
	
	public List<Kind> getAllKinds(){
		return kindRepository.findAll();
	}
	
	public Kind findKindById(long kindId) {
		return kindRepository.findById(kindId).orElse(null);
	}
	
	public Kind createKind(Kind newKind) {
		return kindRepository.save(newKind);
	}
	
	public Kind updateKind(long id , Kind newKind) {
		Kind updateKind = kindRepository.findById(id).orElse(null);
		if(updateKind == null)
			return null;
		updateKind.setKindName(newKind.getKindName());
	    kindRepository.save(updateKind);
	    return updateKind;
	}
}
