package org.csu.hospital.controller;

import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.*;
import org.csu.hospital.domain.ReturnPatientInfo.ReturnPatientInfo;
import org.csu.hospital.domain.ReturnPatientInfo.ReturnPatientInfoDate;
import org.csu.hospital.domain.ReturnPatientInfo.ReturnPatientInfoDateList;
import org.csu.hospital.domain.ReturnPatientInfoById.ReturnPatientInfoById;
import org.csu.hospital.domain.ReturnPatientInfoById.ReturnPatientInfoByIdData;
import org.csu.hospital.domain.ReturnPatientMedRecordById.ReturnPatientMedRecordById;
import org.csu.hospital.domain.ReturnPatientMedRecordById.ReturnPatientMedRecordByIdData;
import org.csu.hospital.domain.ReturnPatientMedRecordById.ReturnPatientMedRecordByIdDataList;
import org.csu.hospital.domain.ReturnPatientUpdate.ReturnPatientUpdate;
import org.csu.hospital.domain.ReturnPatientUpdate.ReturnPatientUpdateData;
import org.csu.hospital.service.DoctorService;
import org.csu.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagePatientInfoController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

//获取病人信息
    @GetMapping("/patients")
    @ResponseBody
    public ReturnPatientInfo getPatientInfo(@RequestParam(value = "query", required = false)Integer query,@RequestParam("pagenum")int pageNum, @RequestParam("pagesize")int pageSize){
        ReturnPatientInfo returnPatientInfo = new ReturnPatientInfo();
        try {
            if(query==null) {
                Meta meta = new Meta();
                ReturnPatientInfoDate returnPatientInfoDate = new ReturnPatientInfoDate();
                meta.setStatus(200);
                meta.setMsg("获取成功");

                PageInfo<Patient> patientPageInfo = patientService.findAllPatients(pageNum,pageSize);
                List<Patient> patients = patientPageInfo.getList();
                List<ReturnPatientInfoDateList> returnPatientInfoDateLists = new ArrayList<ReturnPatientInfoDateList>();
                for(int i=0;i<patients.size();i++){
                    Patient patient = patients.get(i);
                    ReturnPatientInfoDateList returnPatientInfoDateList = new ReturnPatientInfoDateList();
                    returnPatientInfoDateList.setId(patient.getPatId());
                    returnPatientInfoDateList.setName(patient.getPatName());
                    returnPatientInfoDateList.setPatGender(patient.getPatGender());
                    returnPatientInfoDateList.setPhone(patient.getPatName());
                    returnPatientInfoDateLists.add(returnPatientInfoDateList);
                }
                returnPatientInfoDate.setReturnPatientInfoDateLists(returnPatientInfoDateLists);
                returnPatientInfoDate.setTotalpage(patientPageInfo.getPages());
                returnPatientInfoDate.setPagenum(patientPageInfo.getPageNum());
                returnPatientInfo.setMeta(meta);
                returnPatientInfo.setReturnPatientInfoDate(returnPatientInfoDate);

                return returnPatientInfo;
            }
            else {
                Meta meta = new Meta();
                ReturnPatientInfoDate returnPatientInfoDate = new ReturnPatientInfoDate();
                meta.setStatus(200);
                meta.setMsg("获取成功");

                PageInfo<Patient> patientPageInfo = patientService.findAllPatientsByPatId(query,pageNum,pageSize);
                List<Patient> patients = patientPageInfo.getList();
                List<ReturnPatientInfoDateList> returnPatientInfoDateLists = new ArrayList<ReturnPatientInfoDateList>();
                for(int i=0;i<patients.size();i++){
                    Patient patient = patients.get(i);
                    ReturnPatientInfoDateList returnPatientInfoDateList = new ReturnPatientInfoDateList();
                    returnPatientInfoDateList.setId(patient.getPatId());
                    returnPatientInfoDateList.setName(patient.getPatName());
                    returnPatientInfoDateList.setPatGender(patient.getPatGender());
                    returnPatientInfoDateList.setPhone(patient.getPatName());
                    returnPatientInfoDateLists.add(returnPatientInfoDateList);
                }
                returnPatientInfoDate.setReturnPatientInfoDateLists(returnPatientInfoDateLists);
                returnPatientInfoDate.setTotalpage(patientPageInfo.getPages());
                returnPatientInfoDate.setPagenum(patientPageInfo.getPageNum());
                returnPatientInfo.setMeta(meta);
                returnPatientInfo.setReturnPatientInfoDate(returnPatientInfoDate);

                return returnPatientInfo;
            }
        }
        catch (Exception e){
            Meta meta = new Meta();
            meta.setStatus(400);
            meta.setMsg("获取失败");
            returnPatientInfo.setMeta(meta);
            return returnPatientInfo;
        }
    }

    //根据id获取病人信息
    @GetMapping("/patients/{id}")
    @ResponseBody
    public ReturnPatientInfoById getPatientInfoById(@PathVariable("id")Integer id){
        ReturnPatientInfoById returnPatientInfoById = new ReturnPatientInfoById();
        try {
            ReturnPatientInfoByIdData returnPatientInfoByIdData = new ReturnPatientInfoByIdData();
            Meta meta = new Meta();

            meta.setStatus(200);
            meta.setMsg("获取成功");
            Patient patient = patientService.getPatientByPatId(id);
            returnPatientInfoByIdData.setId(patient.getPatId());
            returnPatientInfoByIdData.setAge(patient.getPatAge());
            returnPatientInfoByIdData.setDate(patient.getPatDate());
            returnPatientInfoByIdData.setName(patient.getPatName());
            returnPatientInfoByIdData.setPatGender(patient.getPatGender());
            returnPatientInfoByIdData.setPhone(patient.getPatName());
            returnPatientInfoById.setMeta(meta);
            returnPatientInfoById.setReturnPatientInfoByIdData(returnPatientInfoByIdData);
            return returnPatientInfoById;
        }
        catch (Exception e){
            Meta meta = new Meta();

            meta.setStatus(400);
            meta.setMsg("获取失败");
            returnPatientInfoById.setMeta(meta);
            return returnPatientInfoById;
        }

    }



    //修改病人信息
    @PutMapping("/patients/{id}")
    @ResponseBody
    public ReturnPatientUpdate update (@PathVariable("id")int patId,@RequestParam(value = "name", required = false)String patName,
                        @RequestParam(value = "gender", required = false)String patGender,
                        @RequestParam(value = "age", required = false)Integer patAge,
                        @RequestParam(value = "date", required = false) java.sql.Date patDate,
                        @RequestParam(value = "phone", required = false)String patTel){
        ReturnPatientUpdate returnPatientUpdate = new ReturnPatientUpdate();
        try {
            Meta meta = new Meta();
            meta.setMsg("更新成功");
            meta.setStatus(200);

            Patient patient = patientService.getPatientByPatId(patId);
            if (patName != null) {
                patient.setPatName(patName);
            }
            if (patGender != null) {
                patient.setPatGender(patGender);
            }
            if (patAge != null) {
                patient.setPatAge(patAge);
            }

            if (patDate != null) {
                patient.setPatDate(patDate);
            }
            if (patTel != null) {
                patient.setPatTel(patTel);
            }
            patientService.UpdatePatient(patient);
            Patient patient1 = patientService.getPatientByPatId(patId);
            ReturnPatientUpdateData returnPatientUpdateData = new ReturnPatientUpdateData();
            returnPatientUpdateData.setId(patient1.getPatId());
            returnPatientUpdateData.setName(patient1.getPatName());
            returnPatientUpdateData.setPatGender(patient1.getPatGender());
            returnPatientUpdateData.setPhone(patient1.getPatTel());

            returnPatientUpdate.setMeta(meta);
            returnPatientUpdate.setReturnPatientUpdateData(returnPatientUpdateData);

            return returnPatientUpdate;
        }
        catch (Exception e){
            Meta meta = new Meta();
            meta.setMsg("更新失败");
            meta.setStatus(500);
            returnPatientUpdate.setMeta(meta);
            return returnPatientUpdate;
        }
    }
    //删除Product(只有当item里没有相应的product才能删)
    @DeleteMapping("/patients/{id}")
    @ResponseBody
    public Meta deletePatients(@PathVariable("id")Integer id){
        Meta meta = new Meta();
        try{
            patientService.deletePatients(id);
            meta.setStatus(200);
            meta.setMsg("删除成功");
            return meta;
        }
        catch (Exception e){
            meta.setStatus(400);
            meta.setMsg("删除失败");
            return meta;
        }

    }

    //根据id查看病人病历表
    @GetMapping("/patients/medicalRecords/{id}")
    @ResponseBody
    public ReturnPatientMedRecordById getPatientMedRecordById(@PathVariable("id")Integer id){
        ReturnPatientMedRecordById returnPatientMedRecordById = new ReturnPatientMedRecordById();
        try{
            Meta meta = new Meta();
            meta.setMsg("查询成功");
            meta.setStatus(200);

            ReturnPatientMedRecordByIdData returnPatientMedRecordByIdData = new ReturnPatientMedRecordByIdData();
            MedicalRecord medicalRecord = patientService.getMedicalRecordsByPatient(id);
            List<ReturnPatientMedRecordByIdDataList> returnPatientMedRecordByIdDataLists = new ArrayList<ReturnPatientMedRecordByIdDataList>();
            List<MedicalRecordItem> medicalRecordItem = medicalRecord.getMedicalRecordItems();
            for(int i=0;i<medicalRecordItem.size();i++){
                ReturnPatientMedRecordByIdDataList returnPatientMedRecordByIdDataList = new ReturnPatientMedRecordByIdDataList();
                returnPatientMedRecordByIdDataList.setId(medicalRecordItem.get(i).getItemId());
                returnPatientMedRecordByIdDataList.setDescription(medicalRecordItem.get(i).getDescription());
                returnPatientMedRecordByIdDataList.setPatientName(medicalRecord.getPatName());
                returnPatientMedRecordByIdDataList.setRecid(medicalRecordItem.get(i).getRecId());
                returnPatientMedRecordByIdDataList.setTime(medicalRecordItem.get(i).getTime());
                Doctor doctor = doctorService.getDoctorByDocId(medicalRecordItem.get(i).getDocId());
                returnPatientMedRecordByIdDataList.setDocName(doctor.getDocName());
                returnPatientMedRecordByIdDataLists.add(returnPatientMedRecordByIdDataList);
            }
            returnPatientMedRecordByIdData.setReturnPatientMedRecordByIdDataLists(returnPatientMedRecordByIdDataLists);
            returnPatientMedRecordById.setMeta(meta);
            returnPatientMedRecordById.setReturnPatientMedRecordByIdData(returnPatientMedRecordByIdData);
            return returnPatientMedRecordById;
        }
        catch (Exception e){
            Meta meta = new Meta();
            meta.setMsg("查询失败");
            meta.setStatus(400);
            returnPatientMedRecordById.setMeta(meta);
            return returnPatientMedRecordById;
        }
    }


}
