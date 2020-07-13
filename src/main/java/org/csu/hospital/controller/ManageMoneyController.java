package org.csu.hospital.controller;

import org.csu.hospital.domain.ReturnAllPatientInfo;
import org.csu.hospital.persistence.DoctorMapper;
import org.csu.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage")
public class ManageMoneyController {
    @Autowired
    DoctorService doctorService;


    //查看所有医生工资
    @GetMapping("/salarys")
    @ResponseBody
    public void getPatientInfo(){

    }

}
