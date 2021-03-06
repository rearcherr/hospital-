package org.csu.hospital.controller;

import org.csu.hospital.domain.MedicalRecord;
import org.csu.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MedicalRecordController {

    @Autowired
    PatientService patientService;

    // @GetMapping("/getRecord")
    // @ResponseStatus(value = HttpStatus.OK)
    // public String getRecord(@RequestParam("id") int id) {
    // System.out.println(id);
    // return JSON.toJSONString(patientService.getMedicalRecordsByPatient(id));
    // }

    @GetMapping("/getRecord")
    // @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public MedicalRecord getRecord(@RequestParam("id") int id) {
        System.out.println(id);
        return patientService.getMedicalRecordsByPatient(id);
    }
}
