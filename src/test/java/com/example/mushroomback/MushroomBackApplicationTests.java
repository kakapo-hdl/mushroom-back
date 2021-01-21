package com.example.mushroomback;

import com.mushroom.mgjstreet.entity.SystemUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MushroomBackApplicationTests.class)
@ContextConfiguration
class MushroomBackApplicationTests {

    @Test
    void contextLoads() {

        SystemUser systemUser = new SystemUser();
        systemUser.setUserName("huangdilei");
        systemUser.setPassword("7894561230");
        List<SystemUser> systemUsers = new ArrayList<>();
        systemUsers.add(systemUser);
        systemUsers.add(systemUser);
        for (SystemUser u: systemUsers) {
            System.out.println(u.getUserName()+" "+u.getPassword());
        }
    }
}
