package com.example.services;

import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

//    public List<User> findAllUsers() {
//        return repository.findAllUsers();
//    }

    public User findUserByCredentials(String username, String password) {
        return repository.findUserByCredentials(username, password);
    }

    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    public User findUserById(Long userId) {
        return repository.findUserById(userId);
    }

    public Integer updateProfile(Long id, User newUser) {
        User originalUser = findUserById(id);

        originalUser.setUserName(newUser.getUserName());
        originalUser.setPassword(newUser.getPassword());
        originalUser.setRole(newUser.getRole());

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

        originalUser.setRole(newUser.getRole());

        repository.save(originalUser);
        return 1;
    }

    public Integer deleteUser(Long id) {
        repository.deleteById(id);
        return 1;
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

}
