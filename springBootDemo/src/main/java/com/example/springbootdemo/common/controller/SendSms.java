package com.example.springbootdemo.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;

public class SendSms {
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static JSONObject send(String phone, String verify) throws Exception {
        JSONObject jsonObject = new JSONObject();
        com.aliyun.dysmsapi20170525.Client client = SendSms.createClient("LTAI5tRmG1rnXrNg7sbHabac", "WDC7dhoMzzu4lgjBCQs6AhPtdzLfto");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phone) // 手机号
                .setSignName("****") // 短信签名名称
                .setTemplateCode("SMS_271550069") // 短信模板CODE
                .setTemplateParam(verify); // 验证码
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        jsonObject.put("Code", sendSmsResponse.getBody().getCode());
        jsonObject.put("Message", sendSmsResponse.getBody().getMessage());
        return jsonObject;
    }

}
