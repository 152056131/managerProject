package com.example.managerproject.common.controller;


import com.example.managerproject.common.entity.Userinfo;
import com.example.managerproject.common.service.impl.UserinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kevin
 * @since 2023-09-13
 */
@Controller
@RequestMapping("/common/userinfo")
public class UserinfoController {

    @Autowired
    private UserinfoServiceImpl userinfoService;


    @RequestMapping("login")
    @ResponseBody
    public String loginIndex(Model model, Userinfo userinfo) {
        Userinfo userinfoList = userinfoService.findUserInfo(userinfo);
        if(userinfoList !=null){
            return "1";
        }
        return "0";
    }


}

