package org.csu.hospital.controller;

import org.csu.hospital.domain.Patient;
import org.csu.hospital.service.AccountService;
import org.csu.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") int username,@RequestParam("password") String password)
    {
        Patient patient = new Patient();
        patient.setPatId(username);
        patient.setPatPwd(password);
        if(accountService.verifyAccount(patient))
        {
            return password;
        }
        else {
            return password;
        }
    }
    @PostMapping("/logout")
    @ResponseBody
    public String logout(@RequestParam("username") int username,@RequestParam("password") String password)
    {
        Patient patient = new Patient();
        patient.setPatId(username);
        patient.setPatPwd(password);
        if(accountService.verifyAccount(patient))
        {
            return password;
        }
        else {
            return password;
        }
    }
}
