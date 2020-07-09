package org.csu.hospital;

import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.AccountMapper;
import org.csu.hospital.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalApplicationTests {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountMapper accountMapper;

    @Test
    void contextLoads() {
    }
    @Test
    void testlogin(){
        Patient p = new Patient();
        p.setPatId(111);
        p.setPatPwd("111");
        System.out.println(accountMapper.selectAccountFromUsernameAndPwd(p));
    }

}
