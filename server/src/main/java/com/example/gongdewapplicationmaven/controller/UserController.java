package com.example.gongdewapplicationmaven.controller;


import com.example.gongdewapplicationmaven.dto.UserForm;
import com.example.gongdewapplicationmaven.model.User;
import com.example.gongdewapplicationmaven.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    //모든 회원 정보 가져오기
    @GetMapping("/users/getAll")
    public List<User> getAllusers(){
        return userService.getAllUsers();
    }
    @PostMapping("/api/users/create")
    public ResponseEntity<User> create(@RequestBody UserForm dto){
        log.info(dto.toString());
        User created = userService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}