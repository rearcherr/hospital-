package org.csu.hospital.service;

import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    //这个只验证账号是否存在
    public boolean verifyAccount(Patient patient){
        accountMapper.selectAccountFromUsername(patient.getPatId());
        return true;
    }
    //这个验证账号和密码是否相符
    public boolean verifyAccountAndPassword(Patient patient){
        accountMapper.selectAccountFromUsernameAndPwd(patient);
        return true;
    }
}
