package org.csu.hospital.persistence;

import org.csu.hospital.domain.Medicine;
import org.csu.hospital.domain.PurchaseRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineMapper {
    double getPriceByMedicineId(int id);
    Medicine getMedicineById(int id);
    List<Medicine> getMedicineByPage(int pagenum,int pagesize);
    List<PurchaseRecord> getPurchaseRecordByPage(int pagenum,int pagesize);
    int getPurchaseRecordNum();
    int getMedicineNum();
    void updateMedicine(Medicine medicine);
}
