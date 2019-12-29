package com.muxin.controller;

import com.muxin.bo.UserBO;
import com.muxin.service.UserService;
import com.muxin.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-23 20:26
 */
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username) {

        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名不能为空");
        }

        // 2. 查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户名已经存在");
        }

        // 3. 请求成功，用户名没有重复
        return JSONResult.ok();

    }

    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBO userBO) {

        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 判断用户名和密码不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return JSONResult.errorMsg("用户名或密码不能为空");

        }

        // 1. 查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户名已经存在");
        }

        // 2. 密码长度不能少于6位
        if (password.length() < 6) {
            return JSONResult.errorMsg("密码长度不能少于6位");
        }

        // 3. 判断两次输入密码是否一致
        if(!password.equals(confirmPwd)) {
            return JSONResult.errorMsg("两次密码输入不一致");
        }

        // 4. 实现注册
        userService.createUser(userBO);


        // 3. 请求成功，用户名没有重复
        return JSONResult.ok();

    }
}
