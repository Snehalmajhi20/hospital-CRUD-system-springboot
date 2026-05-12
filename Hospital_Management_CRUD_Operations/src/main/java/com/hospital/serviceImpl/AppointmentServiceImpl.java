package com.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment appointmentSave(Appointment appointment) {
    	Patient patient = patientRepository.findById(
                appointment.getPatient().getPatient_id())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(
                appointment.getDoctor().getDoctor_id())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointmentList() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment appointmentUpdate(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment appointmentDelete(Long id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointmentRepository.delete(appointment);

        return appointment;
    }

    @Override
    public Appointment getAppointmentId(Long id) {

        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }
}
