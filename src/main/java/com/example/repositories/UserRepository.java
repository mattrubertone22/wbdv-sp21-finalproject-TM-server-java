package com.example.repositories;

import com.example.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT user FROM User user")
    public List<User> findAllUsers();

    @Query(value = "SELECT user FROM users WHERE id=:uid", nativeQuery = true)
    public User findUserById(@Param("uid") Long userId);
}
