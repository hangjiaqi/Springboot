package com.cztek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cztek.springboot.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {


    @Query("select u from User u where u.name=:name")
    User findByName(@Param("name") String name);

    User findByUserNameAndPassword(String userName,String password);
    
}
