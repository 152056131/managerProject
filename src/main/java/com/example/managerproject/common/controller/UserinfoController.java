package com.example.managerproject.common.controller;


import com.example.managerproject.common.entity.Userinfo;
import com.example.managerproject.common.service.impl.UserinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * @Description 登录验证
     * @Author kevin
     * @Date 2023/9/15 下午3:59
     * @Version 1.0
     */
    @RequestMapping("login")
    @ResponseBody
    public String loginIndex(Userinfo userinfo) {
        Userinfo userinfoList = userinfoService.findUserInfo(userinfo);
        if(userinfoList !=null){
            return "1";
        }
        return "0";
    }
    /**
     * @Description 修改密码
     * @Author kevin
     * @Date 2023/9/15 下午4:00
     * @Version 1.0
     */
    @RequestMapping("updatePassword")
    @ResponseBody
    public int updatePassword(Userinfo userinfo){
       return userinfoService.updatePassword(userinfo);
    }
}

