package com.example.gongdewapplicationmaven.repository;

import com.example.gongdewapplicationmaven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
