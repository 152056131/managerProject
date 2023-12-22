package com.example.managerproject.common.controller;


import com.example.managerproject.common.entity.WorkLog;
import com.example.managerproject.common.service.impl.WorkLogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Map<String, List> showWorkList(WorkLog workLog) {
        /**
         * 前端页面加载数据时需要后端提供total,rows两种数据
         */
        Map map = new HashMap();
        map.put("total", workLogService.findWorkList(workLog).size());
        List list = workLogService.findWorkList(workLog);
        map.put("rows", list);
        return map;
    }

    /**
     * @Description 新增工作日志
     * @Author kevin
     * @Date 2023/9/25 下午1:50
     * @Version 1.0
     */
    @RequestMapping("work_tail")
    public String addWork(Model model, @RequestParam("option") String option) {
        if(option.equals("add")){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHMMss");
            String id = simpleDateFormat.format(date);
            model.addAttribute("id", id);
        }else if(option.equals("edit")){

        }

        return "work_tail";
    }

    @RequestMapping("common/addworkLog")
    @ResponseBody
    public int addWorkLog(WorkLog workLog) {
        return workLogService.addWorkLog(workLog);
    }

}

