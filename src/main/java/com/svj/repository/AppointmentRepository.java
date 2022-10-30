package com.svj.repository;

import com.svj.entity.Appointment;
import com.svj.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
