package org.csu.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.csu.hospital.domain.Medicine;
import org.csu.hospital.domain.PurchaseRecord;
import org.csu.hospital.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @GetMapping("/medicalExpenses")
    public String getMedicalEnpense(int pagenum, int pagesize) {
        List<PurchaseRecord> purchaseRecordList = medicineService.getPurchaseRecordByPage(pagenum, pagesize);
        JSONObject jsonObject = new JSONObject();
        int totalPage = medicineService.getPurchaseRecordPageNum(pagesize);
        jsonObject.put("totalpage", totalPage);
        jsonObject.put("pagenum", pagenum);
        jsonObject.put("medicalExpenses", purchaseRecordList);
        return JSON.toJSONString(jsonObject);
    }

    @GetMapping("/medicine")
    public String getMedicineList(int pagenum, int pagesize) {
        List<Medicine> medicineList = medicineService.getMedicineByPage(pagenum, pagesize);
        JSONObject jsonObject = new JSONObject();
        int totalPage = medicineService.getMedicinePageNum(pagesize);
        jsonObject.put("totalpage", totalPage);
        jsonObject.put("pagenum", pagenum);
        jsonObject.put("medicine", medicineList);
        return JSON.toJSONString(jsonObject);
    }

    @PutMapping("/medicine/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String updateMedicine(@PathVariable("id") int id,
                                 @RequestParam String name,
                                 @RequestParam BigDecimal price,
                                 @RequestParam int quantity,
                                 @RequestParam String description
    ) {
        Medicine medicine = new Medicine();
        medicine.setMedId(id);
        medicine.setMedName(name);
        medicine.setMedPrice(price);
        medicine.setMedStore(quantity);
        medicine.setMedDesc(description);
        medicineService.updateMedicine(medicine);
        return JSON.toJSONString(medicine);
    }

    @DeleteMapping("/medicine/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String deleteMedicine(@PathVariable("id") int id) {
        medicineService.deleteMedicine(id);
        return "delete  success";
    }

    @GetMapping("/medicine/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String getMedicine(@PathVariable("id") int id) {
        Medicine medicine = medicineService.getMedicine(id);
        return JSON.toJSONString(medicine);
    }

    @PostMapping("/medicine/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String insertMedicine(@PathVariable("id") int id,
                              @RequestParam String name,
                              @RequestParam BigDecimal price,
                              @RequestParam int quantity,
                              @RequestParam String description) {
        Medicine medicine = new Medicine();
        medicine.setMedId(id);
        medicine.setMedName(name);
        medicine.setMedPrice(price);
        medicine.setMedStore(quantity);
        medicine.setMedDesc(description);
        medicineService.insertMedicine(medicine);
        return JSON.toJSONString(medicine);
    }
}
