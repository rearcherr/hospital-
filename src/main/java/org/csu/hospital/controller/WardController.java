package org.csu.hospital.controller;

import com.alibaba.fastjson.JSON;
import org.csu.hospital.domain.Ward;
import org.csu.hospital.persistence.WardMapper;
import org.csu.hospital.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WardController {

    @Autowired
    WardService wardService;

    @PutMapping("/room/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String updateWard(@PathVariable int id,
                             String master,
                             int patient
                             ){
        Ward ward = new Ward();
        ward.setId(id);
        ward.setPatId(patient);
        ward.setMaster(master);
        wardService.updateWard(ward);
        return JSON.toJSONString(ward);
    }

    @DeleteMapping("/room/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String deleteWard(@PathVariable int id
    ){
        wardService.deleteWard(id);
        return "delete success";
    }

}
