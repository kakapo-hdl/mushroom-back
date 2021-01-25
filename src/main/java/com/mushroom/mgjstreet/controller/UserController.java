package com.mushroom.mgjstreet.controller;

import com.mushroom.mgjstreet.entity.SystemUser;
import com.mushroom.mgjstreet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    public void insertUser(   SystemUser systemUser, @RequestParam(value = "imageFile",required = false) MultipartFile File, HttpServletRequest request){
        int flagSuccess;
        System.out.println(systemUser);
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("File = " + File);
        systemUser.setCreateDate(new Date());
        systemUser.setUpdateDate(new Date());
        flagSuccess =userService.insertUser(systemUser);
        if(flagSuccess==1) System.out.println("insert success!");
    }

    @GetMapping("/getAllUser")
    public List<SystemUser> getAllUser(){
        return userService.getAllUsers();
    }


}
