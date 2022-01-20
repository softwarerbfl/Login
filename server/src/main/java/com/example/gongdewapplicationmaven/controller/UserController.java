package com.example.gongdewapplicationmaven.controller;


import com.example.gongdewapplicationmaven.dto.UserForm;
import com.example.gongdewapplicationmaven.model.User;
import com.example.gongdewapplicationmaven.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
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

    //회원 정보 보내기
    @PostMapping("/users/add")
    public User add(@RequestBody UserForm dto){
        User userEntity = dto.toEntity();
        log.info(userEntity.toString()); //불러온 객체를 찍어보기
        User checked=userService.check(userEntity.getId());
        return checked;
    }
//    //회원 정보 보내기
//    @PostMapping("/users/add/{id}")
//    public ResponseEntity<User> add(@PathVariable int id){
//        User checked=userService.check(id);
//        return (checked!=null)?
//                ResponseEntity.status(HttpStatus.OK).body(checked):
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
}