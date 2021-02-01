package com.mushroom.mgjstreet.controller;

import com.mushroom.mgjstreet.entity.CommonValue;
import com.mushroom.mgjstreet.entity.SystemUser;
import com.mushroom.mgjstreet.service.UserService;
import com.mushroom.mgjstreet.util.JwtUtil;
import com.mushroom.util.WriteFileByPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/login")
    public HashMap<String, String> LoginCheck( @RequestParam(value = "userName") String userName,  String password) {
        System.out.println(userName+" "+password);
        SystemUser systemUser = userService.getSystemUserByUserName(userName);
        HashMap<String, String> message = new HashMap<>();
        if(systemUser==null){
            message.put("message","用户不存在");
            message.put("status","1");
        }
        else {
            if(systemUser.getPassword().equals(password)){
                String token = JwtUtil.CreateToken(userName, password);
                message.put("message", "登录成功啦！");
                message.put("token",token);
                message.put("status", "0");

            }
            else {
                message.put("message","密码错误啦！");
                message.put("status","2");
            }
        }
        return message;
    }
    @PostMapping("/insert")
    public void insertUser(  @RequestPart("systemUser") SystemUser systemUser, @RequestParam(value = "imageFile",required = false) MultipartFile file, HttpServletRequest request){
        int flagSuccess;
        String savePath="";
        if(file!=null){
            try {
                 savePath = writeFileByPath.WriteFileByPath(file,CommonValue.HEAD_IMAGE_PATH );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        systemUser.setCreateDate(new Date());
        systemUser.setUpdateDate(new Date());
        systemUser.setHeadImage(savePath);
        flagSuccess =userService.insertUser(systemUser);
    }

    @GetMapping("/getAllUser")
    public List<SystemUser> getAllUser(){
        return userService.getAllUsers();
    }
    @GetMapping("/getSystemUser")
    public  Map getSystemUserById(int id ){
        SystemUser user = userService.getSystemUserById(id);
        if(user.getHeadImage()!="") {
            user.setHeadImage(CommonValue.SERVER_URL + user.getHeadImage());
        }

        HashMap hashMap = new HashMap();
        hashMap.put("user",user);
        return hashMap;
    }


}
