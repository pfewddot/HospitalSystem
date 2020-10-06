package com.kiangsak.thymeleaftdemo1.service;

import java.util.List;

import com.kiangsak.thymeleaftdemo1.entity.Patient;

public interface PatientService {
	public List<Patient> findAll();
	public Patient findById(int theId);
	public void save(Patient thePatient);
	public void deleteById(int theId);

}
