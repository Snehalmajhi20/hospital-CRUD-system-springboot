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

import com.hospital.model.Appointment;
import com.hospital.service.AppointmentService;


@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
	
	@Autowired
    private AppointmentService appointmentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveAppointment(@RequestBody Appointment appointment) {

        Appointment appointment1 = appointmentService.appointmentSave(appointment);

        if (ObjectUtils.isEmpty(appointment1)) {
            return new ResponseEntity<>("Appointment could not be saved!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(appointment1, HttpStatus.CREATED);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAppointments() {

        List<Appointment> getList = appointmentService.getAllAppointmentList();

        return new ResponseEntity<>(getList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAppointment(@RequestBody Appointment appointment) {

        Appointment appointment2 = appointmentService.appointmentUpdate(appointment);

        if (ObjectUtils.isEmpty(appointment2)) {
            return new ResponseEntity<>("Appointment could not be updated!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(appointment2, HttpStatus.OK);
        }
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<?> getAppointmentId(@PathVariable Long id) {

        Appointment appointment3 = appointmentService.getAppointmentId(id);

        if (ObjectUtils.isEmpty(appointment3)) {
            return new ResponseEntity<>("Appointment id not found!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(appointment3, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id) {

        Appointment appointment4 = appointmentService.appointmentDelete(id);

        if (ObjectUtils.isEmpty(appointment4)) {
            return new ResponseEntity<>("Appointment id not found to delete!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>("Appointment Deleted Successfully!",
                    HttpStatus.OK);
        }
    }

}
