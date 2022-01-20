package com.example.gongdewapplicationmaven.controller;


import com.example.gongdewapplicationmaven.model.User;
import com.example.gongdewapplicationmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New User is added";
    }

    @GetMapping("/getAll")
    public List<User> getAllusers(){
        return userService.getAllUsers();
    }





}
