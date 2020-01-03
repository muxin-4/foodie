package com.muxin.service;

import com.muxin.pojo.bo.UserBO;
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

    /**
     * 检索用户名和密码是否匹配,用于登录
     *
     * @param username
     * @param password
     * @return
     */
    public Users queryUserForLogin(String username, String password);
}
