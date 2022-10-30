package com.svj.service;

import com.svj.dto.PatientAppointmentRequest;
import com.svj.entity.Appointment;
import com.svj.entity.Patient;
import com.svj.repository.AppointmentRepository;
import com.svj.repository.PatientRepository;
import com.svj.util.PromoCodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PractoService {
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;

    @Autowired
    public PractoService(AppointmentRepository appointmentRepository, PatientRepository patientRepository){
        this.appointmentRepository= appointmentRepository;
        this.patientRepository= patientRepository;
    }

    @Transactional
    public String bookAppointment(PatientAppointmentRequest request){
        // save patient
        Patient patient= request.getPatient();
        long patientId= patientRepository.save(patient).getPatientId();
        // save appointment
        Appointment appointment= request.getAppointment();

        // rateHospitality(); // it has to be saved even if the parent method fails, so we use new propogation
        // validate user promo code
        if(appointment.getPromoCode()!= null){
            PromoCodeValidator.validatePromoCode(appointment.getPromoCode());
        }
        appointment.setPatientId(patientId);
        String appointmentNo = appointmentRepository.save(appointment).getAppointmentId();
        return String.format( "Hi %s, Your appointment booked successfully and appointment number is %s", patient.getName(), appointmentNo);
    }

    // flexibity to mention which exceptions can rollback or not rollback
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {IllegalArgumentException.class, NullPointerException.class}, noRollbackFor = {ArithmeticException.class})
    public void rateHospitality(){
        // save to db
    }
}
