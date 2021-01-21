package com.mushroom.mgjstreet.service.impl;

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
    public int insertUser(SystemUser systemUser) {
        return  userMapper.insert(systemUser);
    }

    @Override
    public int delete(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(SystemUser systemUser) {
        userMapper.updateById(systemUser);
        return 0;
    }

}
