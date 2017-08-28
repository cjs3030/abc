package com.zhanghui;

import java.util.Date;
import javax.annotation.Resource;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @auther zhanghui
 * @date 2017/8/27 22:10
 * @desc
 */
@Component
public class Sender2 {

    @Resource(name="secondRabbitTemplate")
    private RabbitTemplate secondRabbitTemplate;

    /*
    public void send1() {
        String context = "hello1 " + new Date();
        System.out.println("Sender : " + context);
        this.firstRabbitTemplate.convertAndSend("hello1", context);
    }
    */

    public void send2() {
        String context = "hello2 " + new Date();
        System.out.println("Sender : " + context);
        System.out.println("被动方发送反馈结果：开始...");
        this.secondRabbitTemplate.convertAndSend("hello2", context);
        System.out.println("被动方发送反馈结果：结束...");
    }

}
