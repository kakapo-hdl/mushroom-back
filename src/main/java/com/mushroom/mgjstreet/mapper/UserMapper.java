package com.mushroom.mgjstreet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mushroom.mgjstreet.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<SystemUser> {
//    List<SystemUser> getAllUsers();
//    Integer insertUser(SystemUser systemUser);
//    void delete(Integer userId);
//    void updateUser(SystemUser systemUser);
}
