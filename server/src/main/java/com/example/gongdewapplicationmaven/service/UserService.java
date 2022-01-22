package com.example.gongdewapplicationmaven.service;

import com.example.gongdewapplicationmaven.dto.UserForm;
import com.example.gongdewapplicationmaven.model.User;
import com.example.gongdewapplicationmaven.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UserService{
    @Autowired
    private UserRepository userRepository;
    //전체 USER조회 함수
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User check(Long id){
        User target = userRepository.findById(id).orElse(null);
        if(target==null){
            return null;
        }
        userRepository.save(target);
        log.info(target.toString()); //db에 저장된 객체를 찍어보기
        return target;
    }
    //user생성
    public User create(UserForm dto) {
        User user = dto.toEntity();
        if(user.getId() != null){
            return null;
        }
        return userRepository.save(user);
    }

}