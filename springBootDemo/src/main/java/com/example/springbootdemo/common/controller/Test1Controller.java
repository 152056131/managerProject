package com.example.springbootdemo.common.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.common.entity.Test1;
import com.example.springbootdemo.common.mapper.Test1Mapper;
import com.example.springbootdemo.common.service.impl.Test1ServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户测试表 前端控制器
 * </p>
 *
 * @author kevin
 * @since 2023-02-22
 */
@RestController
@RequestMapping("/common/test1")
@Api(tags = "用户测试1")
public class Test1Controller {

    @Autowired
    Test1ServiceImpl test1;

    @Resource
    Test1Mapper mapper;

    @ApiOperation(value="用户测试1")
    @GetMapping(value = "userTest1")
    public StringBuffer selectUser(Integer pageNum, Integer pageSize){
        IPage<Test1> page = new Page<>(pageNum,pageSize);
        page = mapper.selectPage(page,null);
        List list = page.getRecords();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<=list.size()-1;i++){
            sb.append(list.get(i));
        }
        return sb;

    }

}

