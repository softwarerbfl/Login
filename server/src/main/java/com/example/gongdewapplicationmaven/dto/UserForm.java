package com.example.gongdewapplicationmaven.dto;

import com.example.gongdewapplicationmaven.model.User;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserForm {
//    private int id;
    private String userID; //이메일
    private String userPassword;//비밀번호
    private String name;
    private String userBirth; //생일
    private String userDepartment;//학과
    private String userHabit; //취미
    public User toEntity(){
        return new User( userID,userPassword,name, userBirth,
                userDepartment, userHabit);
    }
}
