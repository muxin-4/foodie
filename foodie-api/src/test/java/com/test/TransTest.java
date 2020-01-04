package com.test;

import com.muxin.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;

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
    private TestTransService testTransService;

//    @Test
    public void myTest() {
        testTransService.testPropagationTrans();
    }
}
