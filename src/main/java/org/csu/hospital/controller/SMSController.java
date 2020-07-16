package org.csu.hospital.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class SMSController {

    @GetMapping("/getCode")
    @ResponseBody
    public String getSMS(@RequestParam("phone") String phoneNum) {
        System.out.println(phoneNum);
        String Code = Integer.toString((int) (Math.random() * 10000)); // 生成四位随机数
        JSONObject msg = new JSONObject();
        try {
            msg.put("code", Code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GJMUtUVcribRWuwEPCi",
                "2xf7FxXRbRi1o95NhUlFjaIdiKQ44m");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "VirtualHos");
        request.putQueryParameter("TemplateCode", "SMS_195863416");
        request.putQueryParameter("TemplateParam", msg.toString());
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();

        }
        return Code;
    }
}
