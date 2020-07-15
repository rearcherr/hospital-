package org.csu.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.csu.hospital.service.DoctorService;
import org.csu.hospital.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ManageFundController {

    @Autowired
    FundService fundService;

    @Autowired
    DoctorService doctorService;

    @GetMapping("/incomes")
    @ResponseStatus(value = HttpStatus.OK)
    public String getIncomes(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("monthIncome",fundService.getTotalInSomeDays(30));
        JSONArray jsonArray = new JSONArray(5);
        jsonArray.add(0,fundService.getTotalAtSomeDaysBefore(0));
        jsonArray.add(1,fundService.getTotalAtSomeDaysBefore(1));
        jsonArray.add(2,fundService.getTotalAtSomeDaysBefore(2));
        jsonArray.add(3,fundService.getTotalAtSomeDaysBefore(3));
        jsonArray.add(4,fundService.getTotalAtSomeDaysBefore(4));
        jsonObject.put("expense",jsonArray);
        return JSON.toJSONString(jsonObject);
    }

    @GetMapping("/expense")
    @ResponseStatus(value = HttpStatus.OK)
    public String getExpense(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalExpense",fundService.getTotalInSomeDays(30)+doctorService.getTotalWage());
        JSONArray jsonArray = new JSONArray(5);
        jsonArray.add(0,fundService.getTotalOutcomeSomeDaysBefore(0));
        jsonArray.add(1,fundService.getTotalOutcomeSomeDaysBefore(1));
        jsonArray.add(2,fundService.getTotalOutcomeSomeDaysBefore(2));
        jsonArray.add(3,fundService.getTotalOutcomeSomeDaysBefore(3));
        jsonArray.add(4,fundService.getTotalOutcomeSomeDaysBefore(4));
        jsonObject.put("expenses",jsonArray);
        return JSON.toJSONString(jsonObject);
    }

}
