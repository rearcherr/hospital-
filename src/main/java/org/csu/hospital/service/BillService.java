package org.csu.hospital.service;

import org.csu.hospital.domain.Bill;
import org.csu.hospital.domain.BillItem;
import org.csu.hospital.persistence.BillMapper;
import org.csu.hospital.persistence.MedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    BillMapper billMapper;

    @Autowired
    MedicineMapper medicineMapper;

    public List<Bill> getBills() {
        return billMapper.getBills();
    }

    public List<Bill> getBillsByPatient(int id) {
        List<Bill> billList = billMapper.getBillsByPatient(id);
        for (Bill bill :
                billList
        ) {
            bill.setBillItems(billMapper.getBillItemsByBill(bill.getId()));
        }
        return billList;
    }

}
