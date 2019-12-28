package com.test;

import com.muxin.Application;
import com.muxin.service.StuService;
import com.muxin.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-18 12:45
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

//    @Test
    public void myTest() {
        testTransService.testPropagationTrans();
    }
}
