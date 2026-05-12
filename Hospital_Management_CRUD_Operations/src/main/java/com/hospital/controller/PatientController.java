package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Patient;
import com.hospital.service.PatientService;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/save")
	public ResponseEntity<?> savePatient(@RequestBody Patient patient){
		Patient patient1 = patientService.patientSave(patient);
		if(ObjectUtils.isEmpty(patient1)) {
			return new ResponseEntity<>("Patient could not be saved!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(patient1, HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listPatients(){
		List<Patient> getList = patientService.getAllpatientList();
		return new ResponseEntity<>(getList, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePateint(@RequestBody Patient patient){
		Patient patient2 = patientService.patientUpdate(patient);
		if(ObjectUtils.isEmpty(patient2)) {
			return new ResponseEntity<>("Patient could not be found to update!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(patient2, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getid/{patient_id}")
	public ResponseEntity<?> getPateintid(@PathVariable Long patient_id){
		Patient patient3 = patientService.getPatientId(patient_id);
		if(ObjectUtils.isEmpty(patient3)) {
			return new ResponseEntity<>("Product id not Found!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(patient3,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/delete/{patient_id}")
	public ResponseEntity<?> PateintDelete(@PathVariable Long patient_id){
		Patient patient4 = patientService.patientDelete(patient_id);
		if(ObjectUtils.isEmpty(patient4)) {
			return new ResponseEntity<>("Product id not Found to delete!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>("Delete Successfully!",HttpStatus.OK);
		}
	}

}
