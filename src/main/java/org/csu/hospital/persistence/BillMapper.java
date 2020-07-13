package org.csu.hospital.persistence;

import org.csu.hospital.domain.Bill;
import org.csu.hospital.domain.BillItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillMapper {
    void createBills(Bill bill);
    List<Bill> getBills();
    List<Bill> getBillsByPatient(int id);
    List<BillItem> getBillItemsByBill(int id);
}
