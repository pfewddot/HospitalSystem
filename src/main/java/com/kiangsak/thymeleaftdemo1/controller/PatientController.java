package com.kiangsak.thymeleaftdemo1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiangsak.thymeleaftdemo1.entity.Patient;
import com.kiangsak.thymeleaftdemo1.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {
private PatientService patientService;
	
	public PatientController(PatientService thePatientService) {
		patientService = thePatientService;
	}

	@GetMapping("/list")
	public String listPatient(Model theModel) {
		List<Patient> thePatient = patientService.findAll();
		theModel.addAttribute("patient", thePatient);
		return "list-employee";
	}
	@GetMapping("/showformforadd")
	public String ShowFormForAdd(Model theModel) {
		Patient thePatient = new Patient();
		theModel.addAttribute("patient",thePatient);
		return "employee-form";
	}
	@GetMapping("/showformforupdate")
	public String ShowFormForUpdate(@RequestParam("patientId") int theId,Model theModel) {
		Patient thePatient = patientService.findById(theId);
		theModel.addAttribute("patient",thePatient);
		return "employee-form";
	}
	@PostMapping("/save")
	public String SavePatient(@ModelAttribute("patient") Patient thePatient) {
	patientService.save(thePatient);
	 return "redirect:/employees/list";
	}
	@GetMapping("/delete")
	public String DeletePatient(@RequestParam("patientId") int theId) {
	patientService.deleteById(theId);
	return "redirect:/employees/list";
	}
}
