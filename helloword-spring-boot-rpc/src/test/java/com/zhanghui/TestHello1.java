package com.zhanghui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @auther zhanghui
 * @date 2017/8/27 22:11
 * @desc
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHello1 {

    @Autowired
    private Sender1 sender1;


    @Test
    public void hello() throws Exception {
        sender1.send1();
        System.in.read();
    }

}
