package org.csu.hospital.service;

import org.csu.hospital.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    //这个只验证账号是否存在
    public boolean verifyAccount(Patient patient){
        return true;
    }
    //这个验证账号和密码是否相符
    public boolean verifyAccountAndPassword(Patient patient){

        return true;
    }
}
