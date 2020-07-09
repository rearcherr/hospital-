package org.csu.hospital.controller;

import org.csu.hospital.domain.*;
import org.csu.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/selectByDoctors")
    @ResponseBody
    public List<Doctor> getDoctorList(){
        List<Doctor> doctors = appointmentService.getDoctorList();
        return doctors;
    }

    //病人登录
    @PostMapping("/login")
    @ResponseBody
    public ReturnLog getPatient(@RequestParam("phone")String patTel, @RequestParam("password")String patPwd){

        int code;
        ReturnLog returnLog;
        try {
            Patient patient = appointmentService.getPatient(patTel);
            String pwd = patient.getPatPwd();
            if (pwd.equals(patPwd)) {
                code = 200;
               int a = (int)((Math.random()*9+1)*10000);
               String token = Integer.toString(a);
               returnLog = new ReturnLog(code,token);
            } else{
                code = 300;
                returnLog = new ReturnLog(code);
            }
            return returnLog;
        }
        catch (Exception e){

            code = 400;
            returnLog = new ReturnLog(code);
            return returnLog;
        }
    }

    //病人注册
    @PostMapping("/register")
    @ResponseBody
    public ReturnCode register(@RequestParam("name")String patName,@RequestParam("phone")String patTel,@RequestParam("password")String patPwd){
        Patient patient=new Patient();
        patient.setPatName(patName);
        patient.setPatTel(patTel);
        patient.setPatPwd(patPwd);
        try {
            appointmentService.insertPatient(patient);
            ReturnCode returnCode = new ReturnCode();
            returnCode.setCode(200);
            return returnCode;
        }
        catch (Exception e){
            ReturnCode returnCode = new ReturnCode();
            returnCode.setCode(400);
            return returnCode;
        }
    }

    //获取科室列表
    @GetMapping("/getOfficeList")
    @ResponseBody
    public ReturnDepartments getDepartments(){
        try {
            ReturnDepartments departments = new ReturnDepartments();
            departments.setCode(200);
            departments.setList(appointmentService.getDepartments());
            return departments;
        }
        catch (Exception e) {
            ReturnDepartments departments = new ReturnDepartments();
            departments.setCode(400);
            departments.setList(null);
            return departments;
        }
    }


}
