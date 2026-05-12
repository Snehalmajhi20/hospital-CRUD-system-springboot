package com.hospital.service;

import java.util.List;

import com.hospital.model.Appointment;

public interface AppointmentService {
	
	public Appointment appointmentSave(Appointment appointment);

    public List<Appointment> getAllAppointmentList();

    public Appointment appointmentUpdate(Appointment appointment);

    public Appointment appointmentDelete(Long id);

    public Appointment getAppointmentId(Long id);

}
