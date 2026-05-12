package com.hospital.service;

import java.util.List;

import com.hospital.model.Patient;

public interface PatientService {

	public Patient patientSave(Patient patient);
	public List<Patient> getAllpatientList();
	public Patient patientUpdate(Patient patient);
	public Patient patientDelete(Long patient_id);
	public Patient getPatientId(Long patient_id);
}
