package org.csu.hospital;

import com.alibaba.fastjson.JSON;
import io.swagger.models.auth.In;
import org.csu.hospital.common.security.JwtTokenUtil;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Manager;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.AccountMapper;
import org.csu.hospital.service.AccountService;
import org.csu.hospital.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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
        Manager manager = new Manager();
        manager.setUsername("111");
        manager.setPassword("1112");
        System.out.println(accountMapper.selectAccountFromUsernameAndPwd(manager));
    }
    @Test
    void testJwt(){
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        Integer username = new Integer(123);
        Map claims = new HashMap<String,Integer>();
        claims.put("admin_username",username);
        String subject = "admin";
        String token = null;
        try {
            //该token过期时间为12h
            token = jwtTokenUtil.createJWT(claims, subject, 1000*60*60*12 );
        } catch (Exception e) {
            throw new RuntimeException("创建Token失败");
        }

        System.out.println("token:"+token);
    }
    @Test
    void jsonTest(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("12","12");
        String a = JSON.toJSONString(map);
        System.out.println(a);
    }





    @Test
    void split(){
        String item= "a,a_content;b,b_content;c,c_content";

        ArrayList<String> mArrayList = new ArrayList<String>();

        String[] splitStrings = item.split(";");
        for (int i = 0; i < splitStrings.length; i++) {
            System.out.println(splitStrings[i]);
        }
    }

    @Test
    void date() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2009, 6 - 1, 30);
        c1.add(Calendar.DATE, 1);
        int date = c1.get(Calendar.MONTH) + 1;
        System.out.println(date);
        System.out.println("rearcher");
    }



}
