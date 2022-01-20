package com.example.gongdewapplicationmaven.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String userID;
    private String userPassword;
    private String userBirth;
    private String userDepartment;
    private String userHabit;
//
//    public User(){
//
//    }
//    public User(int id, String userID, String userPassword, String userBirth,
//                String userDepartment, String userHabit) {
//        this.id = id;
//        this.userID = userID;
//        this.userPassword = userPassword;
//        this.userBirth = userBirth;
//        this.userDepartment = userDepartment;
//        this.userHabit = userHabit;
//
//
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getUserHabit() {
        return userHabit;
    }

    public void setUserHabit(String userHabit) {
        this.userHabit = userHabit;
    }

}
