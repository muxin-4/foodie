package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-25 21:53
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "Hello World~";
    }
}
