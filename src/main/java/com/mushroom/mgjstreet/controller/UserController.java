package com.mushroom.mgjstreet.controller;

import com.mushroom.mgjstreet.entity.SystemUser;
import com.mushroom.mgjstreet.service.UserService;
import com.mushroom.util.WriteFileByPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    private final UserService userService;
    private final JdbcTemplate jdbcTemplate;
    private final WriteFileByPath writeFileByPath;

    @Autowired
    public UserController(UserService userService, JdbcTemplate jdbcTemplate, WriteFileByPath writeFileByPath) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
        this.writeFileByPath = writeFileByPath;
    }

    @PostMapping("/insert")
    public void insertUser(   SystemUser systemUser, @RequestParam(value = "imageFile",required = false) MultipartFile file, HttpServletRequest request){
        int flagSuccess;
        String imageFolder = "headImage";
        System.out.println(systemUser);
        String realPath = request.getSession().getServletContext().getRealPath("/");
        if(!file.isEmpty()){
            try {
                String savePath = writeFileByPath.WriteFileByPath(file, realPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
