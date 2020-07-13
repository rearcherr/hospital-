package org.csu.hospital.controller;

import org.csu.hospital.domain.Patient;
import org.csu.hospital.domain.ReturnAllPatientInfo;
import org.csu.hospital.domain.ReturnPatientUpdate;
import org.csu.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagePatientInfoController {
    @Autowired
    private PatientService patientService;

//获取所有病人信息
    @GetMapping("/patients")
    @ResponseBody
    public ReturnAllPatientInfo getPatientInfo(){
        ReturnAllPatientInfo returnAllPatientInfo = new ReturnAllPatientInfo();
        try {
            returnAllPatientInfo.setCode(200);
            returnAllPatientInfo.setPatientList(patientService.getPatientInfo());
            return returnAllPatientInfo;
        }
        catch (Exception e){
            returnAllPatientInfo.setCode(400);
            return returnAllPatientInfo;
        }
    }

    //修改病人信息
    @PutMapping("/patients/{patientId}")
    @ResponseBody
    public ReturnPatientUpdate update (@PathVariable("patientId")int patientId,@RequestParam(value = "patName", required = false)String patName,
                        @RequestParam(value = "patGender", required = false)String patGender,
                        @RequestParam(value = "patAge", required = false)Integer patAge,
                        @RequestParam(value = "patPwd", required = false)String patPwd,
                        @RequestParam(value = "patDeposit", required = false)Integer patDeposit,
                        @RequestParam(value = "patDate", required = false) java.sql.Date patDate,
                        @RequestParam(value = "patTel", required = false)String patTel){
        ReturnPatientUpdate returnPatientUpdate = new ReturnPatientUpdate();
        try {
            Patient patient = patientService.getPatientByPatId(patientId);
            if (patName != null) {
                patient.setPatName(patName);
            }
            if (patGender != null) {
                patient.setPatGender(patGender);
            }
            if (patAge != null) {
                patient.setPatAge(patAge);
            }
            if (patPwd != null) {
                patient.setPatPwd(patPwd);
            }
            if (patDeposit != null) {
                patient.setPatDeposit(patDeposit);
            }
            if (patDate != null) {
                patient.setPatDate(patDate);
            }
            if (patTel != null) {
                patient.setPatTel(patTel);
            }
            patientService.UpdatePatient(patient);
            Patient patient1 = patientService.getPatientByPatId(patientId);
            returnPatientUpdate.setCode(200);
            returnPatientUpdate.setPatient(patient1);
            return returnPatientUpdate;
        }
        catch (Exception e){
            returnPatientUpdate.setCode(400);
            return returnPatientUpdate;
        }
    }
}
