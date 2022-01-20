package com.example.gongdewapplicationmaven.controller;


import com.example.gongdewapplicationmaven.dto.UserForm;
import com.example.gongdewapplicationmaven.model.User;
import com.example.gongdewapplicationmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;
    //모든 회원 정보 가져오기
    @GetMapping("/getAll")
    public List<User> getAllusers(){
        return userService.getAllUsers();
    }

    //회원 정보 보내기
    @PostMapping("/add/{id}")
    public ResponseEntity<User> add(@PathVariable int id){
        User checked=userService.check(id);
        return (checked!=null)?
                ResponseEntity.status(HttpStatus.OK).body(checked):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
