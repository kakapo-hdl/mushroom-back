package com.mushroom.mgjstreet.service;

import com.mushroom.mgjstreet.entity.SystemUser;

import java.util.List;

public interface UserService {
    List<SystemUser> getAllUsers();
    SystemUser getSystemUserByUserName(String userName);
    int insertUser(SystemUser systemUser);
    int delete(int id);
    int updateUser(SystemUser systemUser);
    SystemUser getSystemUserById(int id);
}
