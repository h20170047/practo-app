package com.svj.dto;

import com.svj.entity.Appointment;
import com.svj.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentRequest {
    private Patient patient;
    private Appointment appointment;
}
