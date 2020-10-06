package com.kiangsak.thymeleaftdemo1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiangsak.thymeleaftdemo1.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
	
	public List <Patient> findAllByorderByFirstNameasc();

}
