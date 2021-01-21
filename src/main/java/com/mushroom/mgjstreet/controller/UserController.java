package com.mushroom.mgjstreet.controller;

import com.mushroom.mgjstreet.entity.SystemUser;
import com.mushroom.mgjstreet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    private final UserService userService;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserController(UserService userService, JdbcTemplate jdbcTemplate) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/insert")
    public void insertUser(@RequestBody SystemUser systemUser){
        int flagSuccess;
        System.out.println(systemUser);
        flagSuccess =userService.insertUser(systemUser);
        if(flagSuccess==1) System.out.println("insert success!");
    }

    @GetMapping("/getAllUser")
    public List<SystemUser> getAllUser(){
        return userService.getAllUsers();
    }
}
