package org.csu.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.csu.hospital.domain.PurchaseRecord;
import org.csu.hospital.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @GetMapping("/medicalExpenses")
    public String getMedicalEnpense(int pagenum,int pagesize){
        List<PurchaseRecord> purchaseRecordList = medicineService.getPurchaseRecordByPage(pagenum,pagesize);
        JSONObject jsonObject = new JSONObject();
        int totalPage = medicineService.getPurchaseRecordPageNum();
        jsonObject.put("totalpage",totalPage);
        jsonObject.put("pagenum",pagenum);
        jsonObject.put("medicalExpenses",purchaseRecordList);
        return JSON.toJSONString(jsonObject);
    }

}
