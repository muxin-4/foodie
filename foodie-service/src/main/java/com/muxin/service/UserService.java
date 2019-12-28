package com.muxin.service;

import com.muxin.pojo.Stu;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-07 18:27
 */
public interface UserService {

    /**
     * 判断用户名是否存在
     */
   public boolean queryUsernameIsExist(String username);
}
