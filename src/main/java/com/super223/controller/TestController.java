package com.super223.controller;

import com.super223.mapper.UserMapper;
import com.super223.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author superz
 */
@RestController
public class TestController {

    /*private final UserMapper userMapper;

    @Autowired
    public TestController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/testMybatisGenerator")
    public String testMybatisGenerator(){

        User user = new User();
        user.setUsername("SuperXZ");
        user.setPassword("123456");
        user.setEmail("super.z.c@qq.com");
        int result = userMapper.insertSelective(user);
        return Integer.toString(result);
    }*/
}
