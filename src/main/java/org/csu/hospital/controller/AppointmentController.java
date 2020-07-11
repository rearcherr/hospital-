package org.csu.hospital.controller;

import org.csu.hospital.domain.*;
import org.csu.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    //按日期选择(日期的格式是 2020-06-30-1 这种的）
    @GetMapping("/selectByDate")
    @ResponseBody
    public ReturnSelectByDate selectByDate(@RequestParam("date")String date,@RequestParam("office")String department){
//        List<Doctor> doctors = appointmentService.getDoctorListByDepartment(department);
        String[] splitStrings = date.split("-");
        ReturnSelectByDate returnSelectByDate = new ReturnSelectByDate();
        Calendar c1 = Calendar.getInstance();
        int year = Integer.parseInt( splitStrings[0]);
        int month = Integer.parseInt( splitStrings[1]);
        int day = Integer.parseInt( splitStrings[2]);
        c1.set(year, month - 1, day);
        List<List<Doctor>> lists = new ArrayList<List<Doctor>>();
        try {
            returnSelectByDate.setCode(200);
            List<ReturnSelectByDateList> a = new ArrayList<ReturnSelectByDateList>();
            returnSelectByDate.setList(a);
            for (int i = 0; i < 7; i++) {
                for (int j = 1; j < 5; j++) {
                    // 获得年份
                    int n = c1.get(Calendar.YEAR);
                    // 获得月份
                    int y = c1.get(Calendar.MONTH) + 1;
                    // 获得日期
                    int r = c1.get(Calendar.DATE);
                    date = n + "-" + y + "-" + r + "-" + j;
                    ReturnSelectByDateList returnSelectByDateList = new ReturnSelectByDateList();
                    returnSelectByDateList.setDate(date);
                    List<Doctor> doctors = appointmentService.getDoctorListByDepartment(department);
                    List<Doctor> doctors1 = appointmentService.getDoctorListByDepartmentAndDate(doctors, date);
                    lists.add(doctors1);
                    System.out.println(date);
                    returnSelectByDateList.setDoctors(doctors1);
                    returnSelectByDate.addList(returnSelectByDateList);

                }
                c1.add(Calendar.DATE, 1);
                }
            return returnSelectByDate;
        }
        catch (Exception e){
            returnSelectByDate.setCode(400);
            return returnSelectByDate;
        }
    }

}
