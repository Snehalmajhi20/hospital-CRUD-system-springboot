package com.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Doctor;
import com.hospital.repository.DoctorRepository;
import com.hospital.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor doctorSave(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctorList() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor doctorUpdate(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor doctorDelete(Long doctor_id) {

        Doctor doctor = doctorRepository.findById(doctor_id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctorRepository.delete(doctor);

        return doctor;
    }

    @Override
    public Doctor getDoctorId(Long doctor_id) {

        return doctorRepository.findById(doctor_id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

}
