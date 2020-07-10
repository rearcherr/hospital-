package org.csu.hospital.service;

import org.csu.hospital.common.security.JwtTokenUtil;
import org.csu.hospital.domain.Manager;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;


    //这个只验证账号是否存在
    public boolean verifyAccount(Manager manager) {
        if (accountMapper.selectAccountFromUsername(manager.getUsername()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    //这个验证账号和密码是否相符
    public boolean verifyAccountAndPassword(Manager manager) {
        if (accountMapper.selectAccountFromUsernameAndPwd(manager) > 0) {
            return true;
        }else {
            return false;
        }
    }

    public String getToken(String username) {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        //存入JWT的payload中生成token
        Map claims = new HashMap<String, String>();
        claims.put("username", username);
        String subject = "admin";
        String token = null;
        try {
            //该token过期时间为12h
            token = jwtTokenUtil.createJWT(claims, subject, 1000 * 60 * 60 * 12);
        } catch (Exception e) {
            throw new RuntimeException("创建Token失败");
        }
        return token;
    }
}

