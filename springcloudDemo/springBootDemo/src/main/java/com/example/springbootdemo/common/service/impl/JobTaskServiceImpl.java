package com.example.springbootdemo.common.service.impl;

import com.example.springbootdemo.common.entity.JobTask;
import com.example.springbootdemo.common.mapper.JobTaskMapper;
import com.example.springbootdemo.common.service.JobTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kevin
 * @since 2023-02-21
 */
@Service
public class JobTaskServiceImpl extends ServiceImpl<JobTaskMapper, JobTask> implements JobTaskService {

}
