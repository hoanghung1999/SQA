package com.example.demo;

import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class UserTest {
    @Autowired
    private ApplicationContext context;

    //User
    @Test
    void TestGetAllUser(){
        UserService userService=context.getBean(UserServiceImpl.class);
        Assertions.assertEquals(10,userService.getAllUser().size());
    }
}
