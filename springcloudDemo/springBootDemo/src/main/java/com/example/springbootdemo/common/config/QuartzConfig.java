package com.example.springbootdemo.common.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
////    @Value("${quartzJob.cron}")
////    private String time;
//    @Bean
//    public JobDetail jobDetail(){
//
//        return JobBuilder.newJob(quartzJob.class)//加载任务实体（必须）
//                .withIdentity("myJob","group1")//设置分组
//                .storeDurably(true)//true会使任务在没有对应触发器的情况下一直存在
//                .build();
//    }
//
//    @Bean
//    public Trigger trigger(){
//
//        //设置Cron时间表达式，此处也可用SimpleScheduleBuilder
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 0/1 * * * ?");
//        //建立触发器
//        return TriggerBuilder.newTrigger()
//                .forJob(jobDetail())//与Job进行绑定
//                .withIdentity("trigger","group1")//分组
//                .withSchedule(cronScheduleBuilder)//绑定触发时间
//                .build();//构建
//    }
}
