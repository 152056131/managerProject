package com.example.springbootdemo.common.controller;


import com.alibaba.fastjson.JSONObject;
import com.aliyun.credentials.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class sendMsg {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @ApiOperation("发送短信测试")
    @PostMapping("/getSms/{phone}")
    public String getSms(@PathVariable("phone") String phone) {
        String s = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(s)) {
            Long expire = redisTemplate.getExpire(phone);
            return phone + ":" + "验证码还有" + expire + "s 过期，可以继续使用";
        }
        String verify = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", verify);
        JSONObject sendResult = null;
        try {
            sendResult = SendSms.send("15522639884", jsonObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sendResult.getString("Code").equals("OK")) {
           /* redisTemplate.opsForValue().set(phone,verify);
            redisTemplate.expireAt(phone,new Date(System.currentTimeMillis()+1000*60));*/
            // 设置短信验证码过期时间一分钟
            redisTemplate.opsForValue().set(phone, verify, 1, TimeUnit.MINUTES);
            return phone + ":" + "验证码发送成功 verify: " + verify;
        }
        return phone + ":" + "验证码发送失败:  " + sendResult.getString("Message");

    }
}
