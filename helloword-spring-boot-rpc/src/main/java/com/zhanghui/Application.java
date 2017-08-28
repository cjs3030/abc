package com.zhanghui;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @auther zhanghui
 * @date 2017/8/26 22:05
 * @desc
 */
@SpringBootApplication
public class Application {

  /*  @Bean
    public  Sender1 sender1(){
        return  new Sender1();
    }
*/

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

}