package com.example.managerproject.common.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.managerproject.common.entity.WorkLog;
import com.example.managerproject.common.service.impl.WorkLogServiceImpl;
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
 * @since 2023-09-21
 */
@Controller
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
    public Page<WorkLog> showWorkList(WorkLog workLog, Integer pageSize, Integer pageNumber) {
        return workLogService.findWorkList(workLog,pageSize,pageNumber);
    }

}

