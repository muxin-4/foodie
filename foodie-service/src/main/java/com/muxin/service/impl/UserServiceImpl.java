package com.muxin.service.impl;

import com.muxin.enums.Sex;
import com.muxin.bo.UserBO;
import com.muxin.mapper.UsersMapper;
import com.muxin.pojo.Users;
import com.muxin.service.UserService;
import com.muxin.utils.DateUtil;
import com.muxin.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-23 19:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String USER_FACE = "https://www.google.com/imgres?imgurl=http%3A%2F%2Fpic.616pic.com%2Fys_bnew_img%2F00%2F06%2F27%2FTWk2P5YJ5k.jpg&imgrefurl=http%3A%2F%2F616pic.com%2Fsucai%2Fz7ri3e251.html&docid=1YZPM1bINDX5SM&tbnid=4lLfk3D9CudG2M%3A&vet=10ahUKEwiOhJ_OyNjmAhUTNaYKHe6eDdAQMwhGKAAwAA..i&w=713&h=714&bih=765&biw=1440&q=%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F&ved=0ahUKEwiOhJ_OyNjmAhUTNaYKHe6eDdAQMwhGKAAwAA&iact=mrc&uact=8";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);

        Users result = usersMapper.selectOneByExample(userExample);

        return result == null ? false : true;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {

//        try {
//            Thread.sleep(3500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        String userId = sid.nextShort();

        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 默认用户昵称同用户名
        user.setNickname(userBO.getUsername());
        // 默认头像
        user.setFace(USER_FACE);
        // 设置默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // 默认性别为保密
        user.setSex(Sex.secret.type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());


        usersMapper.insert(user);

        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {

//        try {
//            Thread.sleep(2500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        Users result = usersMapper.selectOneByExample(userExample);
        return result;
    }
}
