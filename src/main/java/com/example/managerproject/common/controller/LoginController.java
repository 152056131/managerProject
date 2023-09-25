package com.example.managerproject.common.controller;

import com.example.managerproject.common.entity.UserInfo;
import com.example.managerproject.common.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserInfoServiceImpl userinfoService;

    @RequestMapping("/")
    public String loginIndex() {
        return "login";
    }

    @RequestMapping("/index")
    public String loginSucc(Model model,@RequestParam("customerid") String customerid,@RequestParam("password") String password) {
        UserInfo userinfo = new UserInfo();
        userinfo.setCustomerid(customerid);
        userinfo.setPassword(password);
        UserInfo result = userinfoService.findUserInfo(userinfo);
        model.addAttribute("userName",result.getName());
        model.addAttribute("customerid",userinfo.getCustomerid());
        return "index";
    }

}
