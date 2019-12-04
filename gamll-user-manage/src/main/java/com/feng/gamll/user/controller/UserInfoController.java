package com.feng.gamll.user.controller;

import com.feng.gamll.user.bean.UserInfo;
import com.feng.gamll.user.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
    }

    //http://localhost:8080/findUserInfo?name=
    //http://localhost:8080/findUserInfo?id=
    @RequestMapping("findUserInfo")
    public List<UserInfo> findUserInfo(UserInfo userInfo){
        return userInfoService.findUserInfo(userInfo);
    }

    @RequestMapping("findByNickName")
    public List<UserInfo> findByNickName(String nickName){
        return userInfoService.findByNickName(nickName);
    }


    @RequestMapping("addUser")
    public void addUser(UserInfo userInfo){
        userInfoService.addUser(userInfo);
    }

    @RequestMapping("updateUser")
    public void updateUser(UserInfo userInfo){
        userInfoService.updataUser(userInfo);
    }


    @RequestMapping("updateUserById")
    public void updateUserById(UserInfo userInfo){
        userInfoService.updataUserById(userInfo);
    }

    @RequestMapping("deleteUser")
    public void deleteUser(UserInfo userInfo){
        userInfoService.deleteUser(userInfo);
    }
}
