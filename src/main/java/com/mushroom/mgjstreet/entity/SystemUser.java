package com.mushroom.mgjstreet.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SystemUser {
    @TableId(type = IdType.AUTO)
    private Integer id ;

    private String userName;
    private String userAccount;
    private String password;
    private String phone;
    private String email;
    private Integer HeadImageId ;
}
