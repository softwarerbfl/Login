package com.example.gongdewapplicationmaven.service;

import com.example.gongdewapplicationmaven.dto.UserForm;
import com.example.gongdewapplicationmaven.model.User;
import com.example.gongdewapplicationmaven.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    public User check(int id){
        User target = userRepository.findById(id).orElse(null);
        if(target==null){
            return null;
        }
        return target;
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    //전체 USER조회 함수
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
}
