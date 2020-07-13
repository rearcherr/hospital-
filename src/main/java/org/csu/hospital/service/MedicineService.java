package org.csu.hospital.service;

import org.csu.hospital.persistence.MedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MedicineService {

    @Autowired
    MedicineMapper medicineMapper;

    public double getPriceByMedcineId(int id){
        return medicineMapper.getPriceByMedicineId(id);
    }

}
