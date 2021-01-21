package com.mushroom.mgjstreet.service;

import com.mushroom.mgjstreet.entity.SystemUser;

import java.util.List;

public interface UserService {
    List<SystemUser> getAllUsers();
    int insertUser(SystemUser systemUser);
    int delete(int id);
    int updateUser(SystemUser systemUser);
}
