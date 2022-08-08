package com.example.veteriner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.veteriner.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

	Animal findByPetName(String petName);

}
