package com.sqlqueries.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sqlqueries.demo.entity.User;

public interface Repo extends JpaRepository<User,Integer>{
    @Query(value="SELECT * FROM User WHERE id=?1",nativeQuery = true)
    User getUserByUserId(String userId);


    @Query (value="SELECT * FROM User WHERE id=?1 AND address=?2",nativeQuery = true)
    User getUserByUserIdAndAddress(String userId ,String userAddress);

    //When you create update query,you should use (@Modifying) annotation.
}
