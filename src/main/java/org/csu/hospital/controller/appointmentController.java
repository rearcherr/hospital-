package org.csu.hospital.controller;

import org.csu.hospital.domain.Doctor;
import org.csu.hospital.service.appointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/")
public class appointmentController {

    @Autowired
    private appointmentService appointmentService;

    @GetMapping("/selectByDoctors")
    @ResponseBody
    public List<Doctor> getDoctorList(){
        List<Doctor> doctors = appointmentService.getDoctorList();
        return doctors;
    }

}
