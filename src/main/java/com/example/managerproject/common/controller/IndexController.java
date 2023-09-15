package com.example.managerproject.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author kevin
 * @Date 2023/9/15 下午3:13
 * @Version 1.0
 */

@Controller
public class IndexController {

    @RequestMapping("home")
    public String Tohome(){
        return "home";
    }

    @RequestMapping("password")
    public String updatePassword(){
        return "password";
    }
}
