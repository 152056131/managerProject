package com.example.springbootdemo.common.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class testJob extends QuartzJobBean {
    //@Scheduled(cron = "${Scheduling.cron}")
//    public void Scheduling(){
//        System.out.println("测试定时任务");
//    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("执行tesjob");
    }
}
