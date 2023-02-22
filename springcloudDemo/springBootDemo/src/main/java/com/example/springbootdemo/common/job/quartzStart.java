package com.example.springbootdemo.common.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class quartzStart implements ApplicationListener<ApplicationEvent>  {

    private static boolean loaded = false;

    @Resource
    quartzJob quartzJob;

    //这个方法会在容器加载时执行一次
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ContextRefreshedEvent){
            if(!loaded){//避免多次执行
                loaded = true;
                //定时任务启动
                try {
                    //第一遍加载全部任务
                    quartzJob.loadTask();
                    //全部任务都开始执行
                    quartzJob.startJob();
                    System.out.println("任务已经启动...啦啦啦啦啦啦啦");
                } catch (SchedulerException se) {
                    se.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

        }
    }


}