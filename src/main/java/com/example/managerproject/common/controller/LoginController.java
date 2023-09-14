package com.example.managerproject.common.controller;

import com.example.managerproject.common.entity.Userinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String loginIndex() {
        return "login";
    }

    @RequestMapping("/index")
    public String loginSucc() {
        return "/index";
    }

}
