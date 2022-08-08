package com.example.veteriner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.veteriner.model.Kind;

public interface KindRepository extends JpaRepository<Kind,Long> {

}
