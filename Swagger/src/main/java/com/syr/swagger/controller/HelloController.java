package com.syr.swagger.controller;

import com.syr.swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Swagger
 * @author syr
 * // TODO: 2020/12/2
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping(value = "/user")
    public User user(String username,String password){
        return new User(username,password);
    }

    @PostMapping(value = "/hello2")
    public String hello2(String username){
        return "hello"+username;
    }
}
