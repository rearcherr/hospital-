package org.csu.hospital.service;

import org.csu.hospital.persistence.FundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundService {

    @Autowired
    FundMapper fundMapper;

    public int getTotalInSomeDays(int days) {
        return fundMapper.getTotalInSomeDays(days);
    }

    public int getTotalAtSomeDaysBefore(int days) {
        return fundMapper.getTotalAtSomeDaysBefore(days);
    }

    public double getTotalOutcomeSomeDaysBefore(int days){
        return fundMapper.getTotalOutcomeAtSomeDaysBefore(days);
    }

    public double getTotalOutcomeInSomeDays(int days){
        return fundMapper.getTotalOutcomeInSomeDays(days);
    }
}
