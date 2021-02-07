package com.mushroom.mgjstreet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mushroom.mgjstreet.entity.SystemUser;
import com.mushroom.mgjstreet.mapper.UserMapper;
import com.mushroom.mgjstreet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<SystemUser> getAllUsers() {
        List<SystemUser> systemUsers = userMapper.selectList(null);
        return systemUsers;
    }

    @Override
    public SystemUser getSystemUserByUserName(String userName) {
        QueryWrapper<SystemUser> queryCondition = new QueryWrapper<>();
        queryCondition.eq("user_name",userName);
        List<SystemUser> systemUsers = userMapper.selectList(queryCondition);
        if (systemUsers.isEmpty()){
            return null;
        }else {
            return systemUsers.get(0);
        }
    }

    @Override
    public int insertUser(SystemUser systemUser) {
        return  userMapper.insert(systemUser);
    }

    @Override
    public int delete(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(SystemUser systemUser) {
        return   userMapper.updateById(systemUser);
    }

    @Override
    public SystemUser getSystemUserById(int id) {
        return userMapper.selectById(id);
    }

}
