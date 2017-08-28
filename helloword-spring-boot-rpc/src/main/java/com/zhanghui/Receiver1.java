package com.zhanghui;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @auther zhanghui
 * @date 2017/8/27 22:07
 * @desc
 */

@Component
@RabbitListener(queues = "hello1", containerFactory="firstFactory")
public class Receiver1 {

    @Autowired
    Sender2 sender2;

    @RabbitHandler
    public void process(String hello) {
        System.out.println("被动方应用接受到主动方发来的消息,Receiver : " + hello);

        System.out.println("被动方应用开始调用远程方法:开始...");
        //模拟调用远程
        RemoteCallSimulation remoteCallSimulation=new RemoteCallSimulation();
        try {
            remoteCallSimulation.process(hello);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("被动方应用开始调用远程方法:结束...");

        //反馈远程调用调用结果
        sender2.send2();
    }
}
