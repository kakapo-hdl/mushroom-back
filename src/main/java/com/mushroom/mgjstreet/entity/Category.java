package com.mushroom.mgjstreet.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.JDBCType;
import java.util.Date;
import java.util.List;

@Data
public class Category {
    @TableId(type = IdType.AUTO)
    private Integer id ;
    private Integer parentId;
    private String name;
    private String description;
    private String menuLevel;
    private String imageUrl;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate;

    @TableField(exist = false)
    private List<Category> children;

}
