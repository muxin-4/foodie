package com.muxin.service;

import com.muxin.bo.UserBO;
import com.muxin.pojo.Users;

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

    /**
     * 创建用户
     *
     * @param userBO
     * @return
     */
    public Users createUser(UserBO userBO);
}
