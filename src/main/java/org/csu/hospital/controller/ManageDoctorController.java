package org.csu.hospital.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Meta;
import org.csu.hospital.domain.ReturnDoctorInfo.ReturnDoctorInfo1;
import org.csu.hospital.domain.ReturnDoctorInfo.ReturnDoctorInfoData;
import org.csu.hospital.domain.ReturnDoctorInfo.ReturnDoctorInfoDataList;
import org.csu.hospital.domain.ReturnSelectByDoctors.ReturnDoctorInfo;
import org.csu.hospital.domain.ReturnUpdateDocInfo.ReturnUpdateDocInfo;
import org.csu.hospital.domain.ReturnUpdateDocInfo.ReturnUpdateDocInfoData;
import org.csu.hospital.domain.ReturnUpdateDoctorSalarys.ReturnUpdateDoctorSalarys;
import org.csu.hospital.domain.ReturnWordList.ReturnWordList;
import org.csu.hospital.domain.ReturnWordList.ReturnWordListData;
import org.csu.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageDoctorController {
    @Autowired
    DoctorService doctorService;



    //查看医生列表
    @GetMapping("/doctor")
    @ResponseBody
    public ReturnDoctorInfo1 getDoctorList(@RequestParam(value = "query", required = false)Integer query,
                                         @RequestParam("pagenum")int pageNum, @RequestParam("pagesize")int pageSize){
        ReturnDoctorInfo1 returnDoctorInfo1 = new ReturnDoctorInfo1();
        try{
            PageInfo<Doctor> doctorPageInfo = new PageInfo<Doctor>();
            if(query==null){
                doctorPageInfo = doctorService.findAllDoctorSalaryByPageS(pageNum,pageSize);
            }
            else{
                doctorPageInfo = doctorService.findAllDoctorSalaryByPageSAndDocId(query,pageNum,pageSize);
            }
            List<Doctor> doctors = doctorPageInfo.getList();
            List<ReturnDoctorInfoDataList> returnDoctorInfoDataLists = new ArrayList<ReturnDoctorInfoDataList>();
            for(int i=0;i<doctors.size();i++){
                ReturnDoctorInfoDataList returnDoctorInfoDataList = new ReturnDoctorInfoDataList();
                returnDoctorInfoDataList.setId(doctors.get(i).getDocId());
                returnDoctorInfoDataList.setIncome(doctors.get(i).getWage());
                returnDoctorInfoDataList.setMaster(doctors.get(i).getDocDepartment());
                returnDoctorInfoDataList.setName(doctors.get(i).getDocName());
                returnDoctorInfoDataList.setPosition(doctors.get(i).getDocRank());
                returnDoctorInfoDataLists.add(returnDoctorInfoDataList);
            }
            ReturnDoctorInfoData returnDoctorInfoData = new ReturnDoctorInfoData();
            returnDoctorInfoData.setReturnDoctorInfoDataLists(returnDoctorInfoDataLists);
            returnDoctorInfoData.setTotalpage(doctorPageInfo.getPages());
            returnDoctorInfoData.setPagenum(doctorPageInfo.getPageNum());
            Meta meta = new Meta();
            meta.setMsg("获取成功");
            meta.setStatus(200);
            returnDoctorInfo1.setData(returnDoctorInfoData);
            returnDoctorInfo1.setMeta(meta);
            return returnDoctorInfo1;
        }
        catch (Exception e){
            Meta meta = new Meta();
            meta.setMsg("获取失败");
            meta.setStatus(400);
            returnDoctorInfo1.setMeta(meta);
            return returnDoctorInfo1;
        }
    }

    //修改医生信息
    @PutMapping("/doctor/{id}")
    @ResponseBody
    public ReturnUpdateDocInfo Update(@PathVariable("id")Integer id,
                                      @RequestParam(value = "name",required = false)String name,
                                      @RequestParam(value = "master",required = false)String master,
                                      @RequestParam(value = "income",required = false)Integer income,
                                      @RequestParam(value = "position",required = false)String position){
        ReturnUpdateDocInfo returnUpdateDocInfo = new ReturnUpdateDocInfo();
        try{
            Doctor doctor = doctorService.getDoctorByDocId(id);
            if(name!=null){
                doctor.setDocName(name);
            }
            if(master!=null){
                doctor.setDocDepartment(master);
            }
            if(master!=null){
                doctor.setWage(income);
            }
            if(position!=null){
                doctor.setDocRank(position);
            }
            doctorService.updateDoctorInfo(doctor);
            Doctor doctor1 = doctorService.getDoctorByDocId(id);
            ReturnUpdateDocInfoData returnUpdateDocInfoData = new ReturnUpdateDocInfoData();
            returnUpdateDocInfoData.setId(id);
            returnUpdateDocInfoData.setIncome(doctor1.getWage());
            returnUpdateDocInfoData.setMaster(doctor1.getDocDepartment());
            returnUpdateDocInfoData.setName(doctor1.getDocName());
            returnUpdateDocInfoData.setPosition(doctor1.getDocRank());
            returnUpdateDocInfo.setData(returnUpdateDocInfoData);
            Meta meta = new Meta();
            meta.setStatus(200);
            meta.setMsg("更新成功");
            returnUpdateDocInfo.setMeta(meta);
            return returnUpdateDocInfo;
        }
        catch (Exception e){
            Meta meta = new Meta();
            meta.setStatus(500);
            meta.setMsg("更新失败");
            returnUpdateDocInfo.setMeta(meta);
            return returnUpdateDocInfo;
        }
    }

    //删除Product(只有当item里没有相应的product才能删)
    @DeleteMapping("/doctor/{id}")
    @ResponseBody
    public Meta deletePatients(@PathVariable("id")Integer id){
        Meta meta = new Meta();
        try{
            doctorService.deleteDoctor(id);
            meta.setMsg("删除成功");
            meta.setStatus(200);
            return meta;
        }
        catch (Exception e){
            meta.setMsg("删除失败");
            meta.setStatus(400);
            return meta;
        }

    }

}
