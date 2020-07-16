package org.csu.hospital.controller;

import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Meta;
import org.csu.hospital.domain.ReturnDoctorSalarys.ReturnDoctorSalarys;
import org.csu.hospital.domain.ReturnDoctorSalarys.ReturnDoctorSalarysDate;
import org.csu.hospital.domain.ReturnDoctorSalarys.ReturnDoctorSalarysDateList;
import org.csu.hospital.domain.ReturnDoctorSalarys.ReturnDoctorSalarysMeta;
import org.csu.hospital.domain.ReturnUpdateDoctorSalarys.ReturnUpdateDoctorSalarys;
import org.csu.hospital.domain.ReturnUpdateDoctorSalarys.ReturnUpdateDoctorSalarysDate;
import org.csu.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageMoneyController {
    @Autowired
    DoctorService doctorService;

    // 查看医生工资
    @GetMapping("/salarys")
    @ResponseBody
    public ReturnDoctorSalarys getPatientInfo(@RequestParam(value = "query", required = false) String query,
            @RequestParam("pagenum") int pageNum, @RequestParam("pagesize") int pageSize) {

        ReturnDoctorSalarys returnDoctorSalarys = new ReturnDoctorSalarys();

        try {
            if (query == "") {
                ReturnDoctorSalarysMeta returnDoctorSalarysMeta = new ReturnDoctorSalarysMeta();
                ReturnDoctorSalarysDate returnDoctorSalarysDate = new ReturnDoctorSalarysDate();

                returnDoctorSalarysMeta.setStatus(200);
                returnDoctorSalarysMeta.setMsg("获取成功");
                PageInfo<Doctor> doctorPageInfo = doctorService.findAllDoctorSalaryByPageS(pageNum, pageSize);
                List<Doctor> doctors = doctorPageInfo.getList();
                List<ReturnDoctorSalarysDateList> returnDoctorSalarysDateLists = new ArrayList<ReturnDoctorSalarysDateList>();
                for (int i = 0; i < doctors.size(); i++) {
                    ReturnDoctorSalarysDateList returnDoctorSalarysDateList = new ReturnDoctorSalarysDateList();
                    returnDoctorSalarysDateList.setId(doctors.get(i).getDocId());
                    returnDoctorSalarysDateList.setName(doctors.get(i).getDocName());
                    returnDoctorSalarysDateList.setOnduty(doctors.get(i).isOnDuty());
                    returnDoctorSalarysDateList.setWage(doctors.get(i).getWage());
                    returnDoctorSalarysDateList.setDepartment(doctors.get(i).getDocDepartment());
                    returnDoctorSalarysDateList.setRank(doctors.get(i).getDocRank());
                    returnDoctorSalarysDateLists.add(returnDoctorSalarysDateList);
                    System.out.println("name:" + returnDoctorSalarysDateList.getName());
                }
                returnDoctorSalarysDate.setReturnDoctorSalarysDateLists(returnDoctorSalarysDateLists);
                returnDoctorSalarysDate.setTotalpage((int) doctorPageInfo.getTotal());
                returnDoctorSalarysDate.setPagenum(doctorPageInfo.getPageNum());
                returnDoctorSalarys.setDate(returnDoctorSalarysDate);
                returnDoctorSalarys.setMeta(returnDoctorSalarysMeta);

                return returnDoctorSalarys;
            } else {
                ReturnDoctorSalarysMeta returnDoctorSalarysMeta = new ReturnDoctorSalarysMeta();
                ReturnDoctorSalarysDate returnDoctorSalarysDate = new ReturnDoctorSalarysDate();

                returnDoctorSalarysMeta.setStatus(200);
                returnDoctorSalarysMeta.setMsg("获取成功");
                PageInfo<Doctor> doctorPageInfo = doctorService.findAllDoctorSalaryByPageSAndDocName(query, pageNum,
                        pageSize);
                List<Doctor> doctors = doctorPageInfo.getList();
                List<ReturnDoctorSalarysDateList> returnDoctorSalarysDateLists = new ArrayList<ReturnDoctorSalarysDateList>();
                for (int i = 0; i < doctors.size(); i++) {
                    ReturnDoctorSalarysDateList returnDoctorSalarysDateList = new ReturnDoctorSalarysDateList();
                    returnDoctorSalarysDateList.setId(doctors.get(i).getDocId());
                    returnDoctorSalarysDateList.setName(doctors.get(i).getDocName());
                    returnDoctorSalarysDateList.setOnduty(doctors.get(i).isOnDuty());
                    returnDoctorSalarysDateList.setWage(doctors.get(i).getWage());
                    returnDoctorSalarysDateList.setDepartment(doctors.get(i).getDocDepartment());
                    returnDoctorSalarysDateList.setRank(doctors.get(i).getDocRank());
                    returnDoctorSalarysDateLists.add(returnDoctorSalarysDateList);
                    System.out.println("name:" + returnDoctorSalarysDateList.getName());
                }
                returnDoctorSalarysDate.setReturnDoctorSalarysDateLists(returnDoctorSalarysDateLists);
                returnDoctorSalarysDate.setTotalpage((int) doctorPageInfo.getTotal());
                returnDoctorSalarysDate.setPagenum(doctorPageInfo.getPageNum());
                returnDoctorSalarys.setDate(returnDoctorSalarysDate);
                returnDoctorSalarys.setMeta(returnDoctorSalarysMeta);

                return returnDoctorSalarys;
            }
        } catch (Exception e) {
            ReturnDoctorSalarysMeta returnDoctorSalarysMeta = new ReturnDoctorSalarysMeta();
            returnDoctorSalarysMeta.setStatus(400);
            returnDoctorSalarysMeta.setMsg("获取失败");
            returnDoctorSalarys.setMeta(returnDoctorSalarysMeta);
            return returnDoctorSalarys;
        }
    }

    // 修改医生工资信息
    @PutMapping("/salarys/{id}")
    @ResponseBody
    public ReturnUpdateDoctorSalarys Update(@PathVariable("id") long id, @RequestParam("wage") double wage) {
        try {
            Doctor doctor = doctorService.getDoctorByDocId(id);
            doctor.setWage(wage);

            doctorService.updateDoctorWage(doctor);
            ReturnUpdateDoctorSalarys returnUpdateDoctorSalarys = new ReturnUpdateDoctorSalarys();
            ReturnUpdateDoctorSalarysDate returnUpdateDoctorSalarysDate = new ReturnUpdateDoctorSalarysDate();
            returnUpdateDoctorSalarysDate.setDepartment(doctor.getDocDepartment());
            returnUpdateDoctorSalarysDate.setId(doctor.getDocId());
            returnUpdateDoctorSalarysDate.setName(doctor.getDocName());
            returnUpdateDoctorSalarysDate.setRank(doctor.getDocRank());
            returnUpdateDoctorSalarysDate.setWage(doctor.getWage());
            Meta meta = new Meta();
            meta.setMsg("更新成功");
            meta.setStatus(200);
            System.out.println("hh");
            returnUpdateDoctorSalarys.setMeta(meta);
            returnUpdateDoctorSalarys.setReturnUpdateDoctorSalarysDate(returnUpdateDoctorSalarysDate);
            return returnUpdateDoctorSalarys;
        } catch (Exception e) {
            ReturnUpdateDoctorSalarys returnUpdateDoctorSalarys = new ReturnUpdateDoctorSalarys();
            Meta meta = new Meta();
            meta.setMsg("更新失败");
            meta.setStatus(500);
            returnUpdateDoctorSalarys.setMeta(meta);
            return returnUpdateDoctorSalarys;
        }
    }

}
