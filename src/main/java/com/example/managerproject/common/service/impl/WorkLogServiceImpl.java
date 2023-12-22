package com.example.managerproject.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.managerproject.common.entity.WorkLog;
import com.example.managerproject.common.mapper.WorkLogMapper;
import com.example.managerproject.common.service.WorkLogService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kevin
 * @since 2023-09-21
 */
@Service
public class WorkLogServiceImpl extends ServiceImpl<WorkLogMapper, WorkLog> implements WorkLogService {

    @Autowired
    private WorkLogMapper workLogMapper;


    public List<WorkLog> findWorkList(WorkLog workLog) {
        QueryWrapper<WorkLog> queryWrapper = new QueryWrapper<WorkLog>();
        queryWrapper.like(!StringUtils.isNullOrEmpty(workLog.getId()), "id", workLog.getId());
        queryWrapper.like(!StringUtils.isNullOrEmpty(workLog.getUsername()), "username", workLog.getUsername());
        queryWrapper.like(!StringUtils.isNullOrEmpty(workLog.getCreateTime()), "createTime", workLog.getCreateTime());
        List list = new ArrayList();
        list = workLogMapper.selectList(queryWrapper);
        return list;
    }

    public int addWorkLog(WorkLog workLog) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createDate = simpleDateFormat.format(date);
        workLog.setCreateTime(createDate);
        return workLogMapper.insert(workLog);
    }
}
