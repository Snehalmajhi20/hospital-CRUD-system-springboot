package com.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import com.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	
//	@Override
	public Patient patientSave(Patient patient) {
		Patient obj1 = patientRepository.save(patient);
		return obj1;
	}

//	@Override
	public List<Patient> getAllpatientList() {
		List<Patient> listPatients = patientRepository.findAll();
		return listPatients;
	}

//	@Override
	public Patient patientUpdate(Patient patient) {
		Patient obj2 = patientRepository.save(patient);
		return obj2;
	}

//	@Override
	public Patient patientDelete(Long patient_id) {
		Patient obj3 = patientRepository.findById(patient_id).get();
		return obj3;
	}

//	@Override
	public Patient getPatientId(Long patient_id) {
		Patient obj4 = patientRepository.findById(patient_id).get();
		return obj4;
	}

}
