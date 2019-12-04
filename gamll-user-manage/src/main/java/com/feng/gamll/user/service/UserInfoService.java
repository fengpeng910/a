package com.feng.gamll.user.service;

import com.feng.gamll.user.bean.UserInfo;
import org.apache.catalina.User;

import java.util.List;

public interface UserInfoService {
    //返回所有数据
    List<UserInfo> findAll();


    //根据用户ID,或者用户昵称或者根据用户的名称等多个不同的字段进行查询,如果什么都不输入则查询所有
    List<UserInfo> findUserInfo(UserInfo userInfo);


    //模糊查询
    List<UserInfo> findByNickName(String nickName);

    //添加数据
    void addUser(UserInfo userInfo);

    //修改用户
    void updataUser(UserInfo userInfo);

    //修改用户根据主键
    void updataUserById(UserInfo userInfo);

    //删除用户
    void deleteUser(UserInfo userInfo);
}
