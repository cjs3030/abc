package com.zhanghui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @auther zhanghui
 * @date 2017/8/27 22:11
 * @desc
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo01 {

    @Autowired
    private Sender1 sender1;

    @Autowired
    private Sender2 sender2;

    @Test
    public void hello() throws Exception {
        sender1.send1();
        //sender1.send2();
    }

    @Test
    public void hello2() throws Exception {
        //sender2.send1();
        sender2.send2();
    }
}
