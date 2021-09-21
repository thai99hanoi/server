package com.project.HealthyCare.repository;

import com.project.HealthyCare.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.HealthyCare.common.base.BaseRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User> {
    @Transactional
    @Query(value = "SELECT * FROM user\n" +
            "where username = :username and password = :password", nativeQuery = true)
    User findUserByUsername(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT * FROM user\n" +
            "where username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);

    @Transactional
    @Query(value = "select count(*) from user \r\n" + "where username = :username" + " and is_active = 1", nativeQuery = true)
    Integer checkUsername(@Param("username") String username);

    @Transactional
    @Query(value = "UPDATE user SET is_active = 0 WHERE user_id = :userId and is_active = 1",nativeQuery = true)
    void deleteUser(@Param("userId") int userId);

    @Transactional
    @Query(value = "SELECT * FROM user\n" +
            "where user_id != :userId and is_active = 1 and is_online = 1", nativeQuery = true)
    List<User> getUserOnline(@Param("userId") int userId);

}
