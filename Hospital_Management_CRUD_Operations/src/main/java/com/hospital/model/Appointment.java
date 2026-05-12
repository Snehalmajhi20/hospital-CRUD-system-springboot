package com.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	private Long patient_id;
//	private Long doctor_id;
	private String date;
	
	// Many appointments belong to one patient
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // Many appointments belong to one doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
