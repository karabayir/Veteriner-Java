package com.example.veteriner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.veteriner.model.Genus;

public interface GenusRepository extends JpaRepository<Genus, Long> {

}
