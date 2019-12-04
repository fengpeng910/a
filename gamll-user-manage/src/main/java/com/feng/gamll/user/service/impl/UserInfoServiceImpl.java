package com.feng.gamll.user.service.impl;

import com.feng.gamll.user.bean.UserInfo;
import com.feng.gamll.user.mapper.UserInfoMapper;
import com.feng.gamll.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService{
    //调用mapper
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserInfo> findUserInfo(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }

    @Override
    public List<UserInfo> findByNickName(String nickName) {
        //查询哪个表就给哪个实体类
        Example example = new Example(UserInfo.class);
        //构造查询条件
        //第一个参数表示属性,第二个参数表示值!
        example.createCriteria().andLike("nickName","%"+nickName+"%");
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updataUser(UserInfo userInfo) {
        //按照用户的名称来修改
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("nickName",userInfo.getNickName());
        //第一个参数表示要修改的数据内容,第二个参数是跟什么修改:修改的条件
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void updataUserById(UserInfo userInfo) {

        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("nickName",userInfo.getNickName());
        userInfoMapper.deleteByExample(example);
    }
}
