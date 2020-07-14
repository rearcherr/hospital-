package org.csu.hospital.persistence;

import org.csu.hospital.domain.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundMapper {
    int getTotalInSomeDays(int days);
    int getTotalAtSomeDaysBefore(int days);
}
