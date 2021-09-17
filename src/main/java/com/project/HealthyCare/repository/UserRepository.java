package com.project.HealthyCare.repository;

import com.project.HealthyCare.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.HealthyCare.common.base.BaseRepository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    @Transactional
    @Query(value = "SELECT * FROM user\n" +
            "where username = :username and password = :password", nativeQuery = true)
    User findUserByUsername(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT * FROM user\n" +
            "where username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);
}
