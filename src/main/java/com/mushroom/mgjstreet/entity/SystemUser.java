package com.mushroom.mgjstreet.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SystemUser {
    @TableId(type = IdType.AUTO)
    private Integer id ;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private String headImage;
    private boolean sex;
    private String profession;
    private String description;

    @DateTimeFormat
    private Date birthday;

    private Date createDate;
    private Date updateDate;

}
