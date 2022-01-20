package com.example.gongdewapplicationmaven.repository;

import com.example.gongdewapplicationmaven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Override
    ArrayList<User> findAll();
}
