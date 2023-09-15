package com.example.managerproject.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.managerproject.common.entity.Userinfo;
import com.example.managerproject.common.mapper.UserinfoMapper;
import com.example.managerproject.common.service.UserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kevin
 * @since 2023-09-13
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * @Description 查询用户是否存在
     * @Author kevin
     * @Date 2023/9/15 上午9:22
     * @Version 1.0
     */
    public Userinfo findUserInfo(Userinfo userinfo) {
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customerId", userinfo.getCustomerid());
        queryWrapper.eq("password", userinfo.getPassword());
        return userinfoMapper.selectOne(queryWrapper);
    }

    /**
     * @Description 修改密码
     * @Author kevin
     * @Date 2023/9/15 下午4:01
     * @Version 1.0
     */
    public int updatePassword(Userinfo userinfo) {
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customerid", userinfo.getCustomerid());
        System.out.println(userinfo.getCustomerid());
        return userinfoMapper.update(userinfo, queryWrapper);
    }

}
