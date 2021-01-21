package com.mushroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mushroom.mgjstreet.mapper")
//@ComponentScan(basePackages = "com.mushroom.User.mapper.*")
public class MushroomBackApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MushroomBackApplication.class, args);
        }

}
