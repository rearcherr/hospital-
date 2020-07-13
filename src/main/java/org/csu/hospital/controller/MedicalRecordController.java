package org.csu.hospital.controller;

import com.alibaba.fastjson.JSON;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MedicalRecordController {

    @Autowired
    PatientService patientService;

    @GetMapping("/getRecord")
    @ResponseStatus(value = HttpStatus.OK)
    public String getRecord(int id){
        return JSON.toJSONString(patientService.getMedicalRecordsByPatient(id));
    }
}
