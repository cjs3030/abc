package com.zhanghui;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

/**
 * @auther zhanghui
 * @date 2017/8/26 22:03
 * @desc
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}