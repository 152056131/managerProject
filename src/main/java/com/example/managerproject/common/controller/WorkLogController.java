package com.example.managerproject.common.controller;


import com.alibaba.fastjson.JSON;
import com.example.managerproject.common.entity.WorkLog;
import com.example.managerproject.common.service.impl.WorkLogServiceImpl;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kevin
 * @since 2023-09-21
 */
@Controller
@Slf4j
public class WorkLogController {

    @Autowired
    private WorkLogServiceImpl workLogService;


    @RequestMapping("/work")
    public String workLogIndex() {
        return "work";
    }

    /**
     * @Description 展示工作日志列表
     * @Author kevin
     * @Date 2023/9/21 下午2:39
     * @Version 1.0
     */
    @RequestMapping("WorkRecord/SearchWork")
    @ResponseBody
    public Map<String,List> showWorkList(WorkLog workLog, Integer pageSize, Integer pageNumber) {
        for(WorkLog list:workLogService.findWorkList(workLog,pageSize,pageNumber)){
            System.out.println(list);
            System.out.println("======================");
        }
        Map map = new HashMap();
        map.put("total",workLogService.findWorkList(workLog,pageSize,pageNumber).size());
        List list = workLogService.findWorkList(workLog,pageSize,pageNumber);
        map.put("rows",list);
        return map;
    }

    /**
     * @Description 新增工作日志
     * @Author kevin
     * @Date 2023/9/25 下午1:50
     * @Version 1.0
     */
    @RequestMapping("work_tail")
    public String addWork(Model model) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHMMss");
        String id = simpleDateFormat.format(date);
        model.addAttribute("id", id);

        return "work_tail";
    }

    @RequestMapping("common/addworkLog")
    @ResponseBody
    public int addWorkLog(WorkLog workLog) {
       return workLogService.addWorkLog(workLog);

    }

}

