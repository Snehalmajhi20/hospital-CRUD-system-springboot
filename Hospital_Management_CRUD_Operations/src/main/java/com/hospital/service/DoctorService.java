package com.hospital.service;

import java.util.List;

import com.hospital.model.Doctor;

public interface DoctorService {
	
	public Doctor doctorSave(Doctor doctor);

    public List<Doctor> getAllDoctorList();

    public Doctor doctorUpdate(Doctor doctor);

    public Doctor doctorDelete(Long doctor_id);

    public Doctor getDoctorId(Long doctor_id);

}
