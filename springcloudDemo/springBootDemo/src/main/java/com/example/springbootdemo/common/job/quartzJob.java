package com.example.springbootdemo.common.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdemo.common.entity.JobTask;

import com.example.springbootdemo.common.mapper.JobTaskMapper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class quartzJob extends QuartzJobBean{

    @Resource
    JobTaskMapper mapper;
    @Resource
    Scheduler scheduler;


    public void startJob() throws SchedulerException {
        scheduler.start();
    }

    //@Scheduled(cron = "0 0/1 * * * ?")
    public void loadTask() throws Exception {
        QueryWrapper<JobTask> wrapper = new QueryWrapper<JobTask>();
        List<JobTask> list = mapper.selectList(wrapper);
        for (JobTask jobTask:list) {
            //获取一个要修改的触发器的资料，身份，key
            TriggerKey triggerKey = new TriggerKey(jobTask.getName(), jobTask.getGroupid());
            //根据key获取要更改的具体的CronTrigger触发器
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            //如果没有触发器，新建
            if (null == cronTrigger) {
                createJob(jobTask);
            } else {
                updateJob(jobTask,jobTask.getCron());
            }
        }

    }

    public void createJob(JobTask jobTask) throws Exception {
        //批量创建任务
        JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(jobTask.getClassname()))
                .withIdentity(jobTask.getName(), jobTask.getGroupid())
                .build();
        //获取当前Cron时间
        String cron = jobTask.getCron();
        //创建表达式，构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron).withMisfireHandlingInstructionDoNothing();
        //创建触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withSchedule(cronScheduleBuilder)
                .withIdentity(jobTask.getName(), jobTask.getGroupid())
                .build();
        //调度器整合任务与对应的触发器
        scheduler.scheduleJob(jobDetail, cronTrigger);
        log.info("当前job创建成功：{}", jobTask.getName());

    }

    /**
     * 1.此方法会对触发器进行更新，主要更新Cron表达式
     * 2.此方法会判定当前触发器的时间较上一分钟是否存在修改
     * 3.只有判定存在修改时，才会对表达式进行修改
     *
     * @param time 修改后的Cron表达式
     * @throws Exception
     */
    public void updateJob(JobTask jobTask,String time) throws Exception {

        //创建一个要修改的触发器的资料，身份
        TriggerKey triggerKey = new TriggerKey(jobTask.getName(), jobTask.getGroupid());
        //获取要更改的具体的CronTrigger触发器
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        //获取当前时间
        String oldTime = cronTrigger.getCronExpression();
        if (!oldTime.equals(time)) {
            //用修改后的时间更新触发器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(time).withMisfireHandlingInstructionDoNothing();
            CronTrigger cronTrigger1 = TriggerBuilder.newTrigger()
                    .withIdentity(jobTask.getName(), jobTask.getGroupid())
                    .withSchedule(cronScheduleBuilder)
                    .build();
            //调度器整合新的触发器
            scheduler.rescheduleJob(triggerKey, cronTrigger1);
            log.info("监听到修改，任务“{}”发生修改，修改前执行时间为：{} ，修改后执行时间为： {}", jobTask.getName(), oldTime, time);
        }

    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("执行quartz");
    }
}
