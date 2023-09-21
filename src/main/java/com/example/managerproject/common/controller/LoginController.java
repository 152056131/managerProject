package com.example.managerproject.common.controller;

import com.example.managerproject.common.entity.Userinfo;
import com.example.managerproject.common.mapper.UserinfoMapper;
import com.example.managerproject.common.service.impl.UserinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserinfoServiceImpl userinfoService;

    @RequestMapping("/")
    public String loginIndex() {
        return "login";
    }

    @RequestMapping("/index")
    public String loginSucc(Model model,@RequestParam("customerid") String customerid,@RequestParam("password") String password) {
        Userinfo userinfo = new Userinfo();
        userinfo.setCustomerid(customerid);
        userinfo.setPassword(password);
        Userinfo result = userinfoService.findUserInfo(userinfo);
        model.addAttribute("userName",result.getName());
        return "index";
    }

}
