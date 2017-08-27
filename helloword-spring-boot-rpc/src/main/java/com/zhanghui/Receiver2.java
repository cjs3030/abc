package com.zhanghui;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



/**
 * @auther zhanghui
 * @date 2017/8/27 22:08
 * @desc
 */
@Component
@RabbitListener(queues = "hello2", containerFactory="secondFactory" )
public class Receiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("主动方收到被动方反馈结果：处理开始...");
        System.out.println("Receiver : " + hello);
        System.out.println("主动方收到被动方反馈结果：处理结束...");

        System.out.println("主动方应用调用被动方应用 结束...");

    }
}