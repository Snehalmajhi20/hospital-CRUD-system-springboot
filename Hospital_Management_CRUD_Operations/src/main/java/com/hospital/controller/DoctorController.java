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

import com.hospital.model.Doctor;
import com.hospital.service.DoctorService;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
	
	@Autowired
    private DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor) {

        Doctor doctor1 = doctorService.doctorSave(doctor);

        if (ObjectUtils.isEmpty(doctor1)) {
            return new ResponseEntity<>("Doctor could not be saved!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(doctor1, HttpStatus.CREATED);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listDoctors() {

        List<Doctor> getList = doctorService.getAllDoctorList();

        return new ResponseEntity<>(getList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor) {

        Doctor doctor2 = doctorService.doctorUpdate(doctor);

        if (ObjectUtils.isEmpty(doctor2)) {
            return new ResponseEntity<>("Doctor could not be updated!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(doctor2, HttpStatus.OK);
        }
    }

    @GetMapping("/getid/{doctor_id}")
    public ResponseEntity<?> getDoctorId(@PathVariable Long doctor_id) {

        Doctor doctor3 = doctorService.getDoctorId(doctor_id);

        if (ObjectUtils.isEmpty(doctor3)) {
            return new ResponseEntity<>("Doctor id not found!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(doctor3, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{doctor_id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long doctor_id) {

        Doctor doctor4 = doctorService.doctorDelete(doctor_id);

        if (ObjectUtils.isEmpty(doctor4)) {
            return new ResponseEntity<>("Doctor id not found to delete!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>("Doctor Deleted Successfully!",
                    HttpStatus.OK);
        }
    }

}
