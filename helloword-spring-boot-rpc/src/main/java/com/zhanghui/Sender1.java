package com.zhanghui;

import java.util.Date;
import javax.annotation.Resource;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @auther zhanghui
 * @date 2017/8/27 22:09
 * @desc
 */
@Component
public class Sender1 {

    @Resource(name="firstRabbitTemplate")
    private RabbitTemplate firstRabbitTemplate;

    public void send1() {
        String context = "hello1 " + new Date();
        System.out.println("Sender : " + context);
        System.out.println("主动方应用调用被动方应用 开始...");
        this.firstRabbitTemplate.convertAndSend("hello1", context);
    }

   /*
   public void send2() {
        String context = "hello2 " + new Date();
        System.out.println("Sender : " + context);
        this.firstRabbitTemplate.convertAndSend("hello2", context);
    }
    */

}