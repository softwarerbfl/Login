package com.example.gongdewapplicationmaven.service;

import com.example.gongdewapplicationmaven.model.User;

import javax.swing.*;
import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();

    User check(String id);
}
