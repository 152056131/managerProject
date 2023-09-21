package com.example.managerproject.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.managerproject.common.entity.UserInfo;
import com.example.managerproject.common.mapper.UserInfoMapper;
import com.example.managerproject.common.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kevin
 * @since 2023-09-13
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userinfoMapper;

    /**
     * @Description 查询用户是否存在
     * @Author kevin
     * @Date 2023/9/15 上午9:22
     * @Version 1.0
     */
    public UserInfo findUserInfo(UserInfo userinfo) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
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
    public int updatePassword(UserInfo userinfo) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customerid", userinfo.getCustomerid());
        return userinfoMapper.update(userinfo, queryWrapper);
    }


}
