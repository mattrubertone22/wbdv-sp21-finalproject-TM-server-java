package com.example.services;

import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    public User findUserById(Long userId) {
        return repository.findUserById(userId);
    }

    public Integer updateUsername(Long id, User newUsername) {
        User originalUser = findUserById(id);

        originalUser.setUsername(newUsername.getUsername());

        repository.save(originalUser);
        return 1;
    }

    public Integer updatePassword(Long id, User newPassword) {
        User originalUser = findUserById(id);

        originalUser.setPassword(newPassword.getPassword());

        repository.save(originalUser);
        return 1;
    }

    public Integer updateUserType(Long id, User newUser) {
        User originalUser = findUserById(id);

        originalUser.setType(newUser.getType());

        repository.save(originalUser);
        return 1;
    }

    public Integer deleteUser(Long id) {
        repository.deleteById(id);
        return 1;
    }

}
