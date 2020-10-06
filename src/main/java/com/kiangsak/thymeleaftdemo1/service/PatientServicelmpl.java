package com.kiangsak.thymeleaftdemo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiangsak.thymeleaftdemo1.dao.PatientRepository;
import com.kiangsak.thymeleaftdemo1.entity.Patient;

@Service
public class PatientServicelmpl implements PatientService {
	private PatientRepository patientRepository;

	@Autowired
	public PatientServicelmpl(PatientRepository thePatientRepository) {
		patientRepository = thePatientRepository;
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findById(int theId) {
		Optional<Patient> result = patientRepository.findById(theId);
		Patient thePatient = null;
		if (result.isPresent()) {
			thePatient = result.get();
		} else {
			throw new RuntimeException("Did not find patient id -" + theId);
		}
		return thePatient;
	}

	@Override
	public void save(Patient thePatient) {
		patientRepository.save(thePatient);
	}

	@Override
	public void deleteById(int theId) {
		patientRepository.deleteById(theId);
	}

}
