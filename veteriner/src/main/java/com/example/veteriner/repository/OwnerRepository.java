package com.example.veteriner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.veteriner.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

	Owner findByOwnerName(String ownerName);

}
