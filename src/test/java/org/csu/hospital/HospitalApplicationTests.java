package org.csu.hospital;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.csu.hospital.common.security.JwtTokenUtil;
import org.csu.hospital.domain.Bill;
import org.csu.hospital.domain.Manager;
import org.csu.hospital.persistence.*;
import org.csu.hospital.service.AccountService;
import org.csu.hospital.service.BillService;
import org.csu.hospital.service.MedicineService;
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

    @Autowired
    BillMapper billMapper;

    @Autowired
    MedicineMapper medicineMapper;

    @Autowired
    BillService billService;

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    FundMapper fundMapper;

    @Autowired
    MedicineService medicineService;

    @Test
    void contextLoads() {
    }

    @Test
    void testlogin() {
        Manager manager = new Manager();
        manager.setUsername("111");
        manager.setPassword("1112");
        System.out.println(accountMapper.selectAccountFromUsernameAndPwd(manager));
    }

    @Test
    void testJwt() {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        Integer username = new Integer(123);
        Map claims = new HashMap<String, Integer>();
        claims.put("admin_username", username);
        String subject = "admin";
        String token = null;
        try {
            //该token过期时间为12h
            token = jwtTokenUtil.createJWT(claims, subject, 1000 * 60 * 60 * 12);
        } catch (Exception e) {
            throw new RuntimeException("创建Token失败");
        }

        System.out.println("token:" + token);
    }

    @Test
    void jsonTest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("12", "12");
        String a = JSON.toJSONString(map);
        System.out.println(a);
    }


    @Test
    void split() {
        String item = "a,a_content;b,b_content;c,c_content";

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

    @Test
    void order() {
//        System.out.println(billMapper.getBills());
//        Bill bill = new Bill();
//        bill.setDate(new Date());
//        bill.setTotalPrice(new BigDecimal(123));
//        bill.setStatus(1);
//        bill.setPatient(3);
//        billMapper.createBills(bill);
        List<Bill> billList = billService.getBillsByPatient(3);
        for (Bill bill : billList
        ) {
            System.out.println(bill.getTotalPrice());
        }

    }

    @Test
    void medicine() {
        System.out.println(medicineMapper.getPriceByMedicineId(1));
    }

    @Test
    void record() {
        System.out.println(patientMapper.getItemListByRecord(1).get(1).getTime());
    }
    @Test
    void json(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa",111);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("aaa",111);
        JSONArray jsonArray = new JSONArray();
//        jsonObject.
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject2);
        System.out.println(JSON.toJSONString(jsonArray));
    }
    @Test
    void testSql(){
//        List<Bill> billList = fundMapper.getBillsInSomeDays(3);
//        System.out.println(billList);
//        List<BillItem> medicalRecordItems = billMapper.getBillItemsByBill(1);
//        System.out.println(medicalRecordItems.get(0).getName());
        System.out.println(medicineService.getPurchaseRecordByPage(0,2));
    }


}
