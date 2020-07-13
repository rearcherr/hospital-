package org.csu.hospital.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class ManageFundController {
    @GetMapping("/incomes")
    @ResponseStatus(value = HttpStatus.OK)
    public String getIncomes(){
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put()
        return "111";
    }

}
