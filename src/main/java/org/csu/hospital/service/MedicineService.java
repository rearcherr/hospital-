package org.csu.hospital.service;

import org.csu.hospital.domain.MedicalRecord;
import org.csu.hospital.domain.Medicine;
import org.csu.hospital.domain.PurchaseRecord;
import org.csu.hospital.persistence.MedicineMapper;
import org.csu.hospital.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MedicineService {

    @Autowired
    MedicineMapper medicineMapper;

    public double getPriceByMedcineId(int id) {
        return medicineMapper.getPriceByMedicineId(id);
    }

    public List<PurchaseRecord> getPurchaseRecordByPage(int pagenum, int pagesize) {
        pagenum  = pagesize * pagenum;
        List<PurchaseRecord> purchaseRecordList = medicineMapper.getPurchaseRecordByPage(pagenum,pagesize);
        for (PurchaseRecord purchaseRecord:purchaseRecordList
             ) {
            System.out.println(purchaseRecord.getMedId());
            purchaseRecord.setName((medicineMapper.getMedicineById(purchaseRecord.getMedId()).getMedName()));
        }
        return purchaseRecordList;
    }

    public int getPurchaseRecordPageNum() {
        return (int)((medicineMapper.getPurchaseRecordNum())/10+1);
    }

}
