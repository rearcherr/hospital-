package org.csu.hospital.controller;

import com.alibaba.fastjson.JSON;
import org.csu.hospital.domain.Manager;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.service.AccountService;
import org.csu.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/managers")
public class ManagersAccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/tokens")
    @ResponseBody
    public String login(@RequestParam("username") String username,@RequestParam("password") String password)
    {
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(password);
        Map<String,String> responseMap = new HashMap<String, String>();
        if(accountService.verifyAccount(manager))
        {
            //对应账号密码正确
            if(accountService.verifyAccountAndPassword(manager)){
                String token = accountService.getToken(username);
                responseMap.put("code","200");
                responseMap.put("token",token);
                String responseJson = JSON.toJSONString(responseMap);
                return responseJson;
            }else {
                //对于账号存在但是密码不正确
                responseMap.put("code","300");
                String responseJson = JSON.toJSONString(responseMap);
                return responseJson;
            }
        }
        else {
            //对于账号不存在
            responseMap.put("code","400");
            String responseJson = JSON.toJSONString(responseMap);
            return responseJson;
        }
    }
    @GetMapping("/tokens/{username}")
    @ResponseBody
    public String logout(@PathVariable String username)
    {
        Map<String,String> responseMap = new HashMap<String, String>();
        responseMap.put("code","200");
        return JSON.toJSONString(responseMap);
    }
}
