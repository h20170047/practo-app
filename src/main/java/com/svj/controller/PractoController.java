package com.svj.controller;

import com.svj.dto.PatientAppointmentRequest;
import com.svj.service.PractoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PractoController {
    private PractoService practoService;

    @Autowired
    public PractoController(PractoService practoService){
        this.practoService= practoService;
    }

    @PostMapping("/bookappointment")
    public String bookDOctorsAppointment(@RequestBody PatientAppointmentRequest request){
        return practoService.bookAppointment(request);
    }
}
