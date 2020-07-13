package org.csu.hospital.controller;

import com.alibaba.fastjson.JSON;
import org.csu.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("/getBill")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String getBill(int id) {
        return JSON.toJSONString(billService.getBills());
    }

}
