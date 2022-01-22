package com.example.gongdewapplicationmaven.repository;

import com.example.gongdewapplicationmaven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    ArrayList<User> findAll();

    @Query("select u from User u where u.email = :email and u.password= :password")
    User findByEmailAddress(@Param("email") String email,
                            @Param("password") String password);
    @Query("select u from User u where u.email = :email")
    User checkDuplicaionByEmailAddress(@Param("email") String email);
}
