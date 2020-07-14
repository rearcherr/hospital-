package org.csu.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Meta;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.domain.ReturnWordList.ReturnWordList;
import org.csu.hospital.domain.ReturnWordList.ReturnWordListData;
import org.csu.hospital.domain.ReturnWordList.ReturnWordListDataList;
import org.csu.hospital.domain.Ward;
import org.csu.hospital.persistence.WardMapper;
import org.csu.hospital.service.PatientService;
import org.csu.hospital.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WardController {

    @Autowired
    WardService wardService;
    @Autowired
    PatientService patientService;




    @PutMapping("/room/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String updateWard(@PathVariable int id,
                             String master,
                             int patient
                             ){
        Ward ward = new Ward();
        ward.setId(id);
        ward.setPatId(patient);
        ward.setMaster(master);
        wardService.updateWard(ward);
        return JSON.toJSONString(ward);
    }

    @DeleteMapping("/room/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String deleteWard(@PathVariable int id
    ){
        wardService.deleteWard(id);
        return "delete success";
    }


    //查看病房列表
    @GetMapping("/room")
    @ResponseBody
    public ReturnWordList getWordList(@RequestParam(value = "query", required = false)Integer query,
                                      @RequestParam("pagenum")int pageNum, @RequestParam("pagesize")int pageSize) {
        ReturnWordList returnWordList = new ReturnWordList();
        try{
            PageInfo<Ward> wardPageInfo = new PageInfo<Ward>();
            if(query==null){
                wardPageInfo = wardService.findAllWardsByPageS(pageNum,pageSize);
            }
            else {
                wardPageInfo = wardService.findAllWardsByPageSById(query,pageNum,pageSize);
            }
            List<Ward> wards = wardPageInfo.getList();
            List<ReturnWordListDataList> returnWordListDataLists = new ArrayList<ReturnWordListDataList>();
            for(int i=0;i<wards.size();i++){
                ReturnWordListDataList returnWordListDataList = new ReturnWordListDataList();
                returnWordListDataList.setId(wards.get(i).getId());
                Patient patient = patientService.getPatientByPatId(wards.get(i).getPatId());
                returnWordListDataList.setMaster(wards.get(i).getMaster());
                returnWordListDataList.setPatient(patient.getPatName());
                returnWordListDataList.setDate(patient.getPatDate());
                returnWordListDataLists.add(returnWordListDataList);
            }
            Meta meta = new Meta();
            meta.setStatus(200);
            meta.setMsg("获取成功");

            ReturnWordListData returnWordListData = new ReturnWordListData();
            returnWordListData.setTotalpage(wardPageInfo.getPages());
            returnWordListData.setPagenum(wardPageInfo.getPageNum());
            returnWordListData.setPatients(returnWordListDataLists);
            returnWordList.setData(returnWordListData);
            returnWordList.setMeta(meta);

            return returnWordList;
        }
        catch (Exception e){
            Meta meta = new Meta();
            meta.setStatus(400);
            meta.setMsg("获取失败");
            returnWordList.setMeta(meta);
            return returnWordList;
        }
    }


}
