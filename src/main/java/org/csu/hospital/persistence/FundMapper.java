package org.csu.hospital.persistence;

import org.csu.hospital.domain.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundMapper {
    List<Bill> getBillsInSomeDays(int days);
}
