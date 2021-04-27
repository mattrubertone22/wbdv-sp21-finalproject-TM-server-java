package com.example.repositories;

import com.example.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select user FROM User user WHERE user.userName=:userName")
    public User findUserByUsername(@Param("userName") String userName);

    @Query("select user FROM User user WHERE user.userName=:userName and user.password=:password")
    public User findUserByCredentials(@Param("userName") String userName, @Param("password") String password);

    @Query("SELECT user FROM User user")
    public List<User> findAllUsers();

    @Query("SELECT user FROM User user WHERE user.id=:uid")
    public User findUserById(@Param("uid") Long userId);
}
