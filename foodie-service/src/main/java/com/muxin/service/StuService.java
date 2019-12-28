package com.muxin.service;

import com.muxin.pojo.Stu;

/**
 * @program: foodie
 * @description:
 * @author: Mr.Wang
 * @create: 2019-07 18:27
 */
public interface StuService {

    public Stu getStuInfo(int id);

    public void saveStu();

    public void updateStu(int id);

    public void deleteStu(int id);

    public void saveParent();

    public void saveChildren();
}
