package org.csu.hospital.controller;

import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.domain.returnLog;
import org.csu.hospital.service.appointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    @ResponseBody
    public returnLog getPatient(@RequestParam("phone")String patTel,@RequestParam("password")String patPwd){

        int code;
        returnLog returnLog;
        try {
            Patient patient = appointmentService.getPatient(patTel);
            String pwd = patient.getPatPwd();
            if (pwd.equals(patPwd)) {
                code = 200;
               int a = (int)((Math.random()*9+1)*10000);
               String token = Integer.toString(a);
               returnLog = new returnLog(code,token);
            } else{
                code = 300;
                returnLog = new returnLog(code);
            }
            return returnLog;
        }
        catch (Exception e){

            code = 400;
            returnLog = new returnLog(code);
            return returnLog;
        }
    }

}
