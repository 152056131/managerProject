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
    UserinfoMapper userinfoMapper;

    public String findUserInfo(Userinfo userinfo) {
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customerId", userinfo.getCustomerid());
        queryWrapper.eq("password", userinfo.getPassword());
        List list = userinfoMapper.selectList(queryWrapper);
        return String.valueOf(list.size());
    }
}
