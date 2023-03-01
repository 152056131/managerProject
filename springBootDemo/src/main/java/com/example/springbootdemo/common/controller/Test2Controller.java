package com.example.springbootdemo.common.controller;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kevin
 * @since 2023-02-22
 */
@RestController
@RequestMapping("/common/test2")
@RequiredArgsConstructor
public class Test2Controller {
    private final RabbitTemplate rabbitTemplate;
    private final Queue myQueue;
    @ApiOperation("发送mq消息")
    @RequestMapping("sendmq")
    public String sendmq(String msg){
        rabbitTemplate.convertAndSend(myQueue.getName(),msg);
        return "ok";
    }

    @ApiOperation("接受mq消息")
    @GetMapping("getmq")
    @RabbitListener(queues = {"TestDirectQueue"})
    public void getmq(@Payload String msg){
        System.out.println("================================================"+msg);
    }

}

