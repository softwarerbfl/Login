package com.example.gongdewapplicationmaven.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column
    private String userID; //이메일
    @Column
    private String userPassword;//비밀번호
    @Column
    private String name;//사용자 이름
    @Column
    private String userBirth; //생일
    @Column
    private String userDepartment;//학과
    @Column
    private String userHabit; //취미
    public String getId() {
        return userID;
    }
}
