package com.example.gongdewapplicationmaven.service;

import com.example.gongdewapplicationmaven.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
}
