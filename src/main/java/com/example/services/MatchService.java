package com.example.services;

import com.example.models.Match;
import com.example.models.User;
import com.example.repositories.MatchRepository;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    MatchRepository repository;

    public Match createComment(Match comment) {
        return repository.save(comment);
    }

    public List<Match> findCommentByUserId(Long userId) {
        return repository.findCommentByUserId(userId);
    }

    public List<Match> findCommentByTeamId(Long teamId) {
        return repository.findCommentByTeamId(teamId);
    }
//
////    public List<User> findAllUsers() {
////        return repository.findAllUsers();
////    }
//
//    public User findUserByCredentials(String username, String password) {
//        return repository.findUserByCredentials(username, password);
//    }
//
//    public User findUserByUsername(String username) {
//        return repository.findUserByUsername(username);
//    }
//
//    public User findUserById(Long userId) {
//        return repository.findUserById(userId);
//    }
//
//    public Integer updateUsername(Long id, User newUsername) {
//        User originalUser = findUserById(id);
//
//        originalUser.setUserName(newUsername.getUserName());
//
//        repository.save(originalUser);
//        return 1;
//    }
//
//    public Integer updatePassword(Long id, User newPassword) {
//        User originalUser = findUserById(id);
//
//        originalUser.setPassword(newPassword.getPassword());
//
//        repository.save(originalUser);
//        return 1;
//    }
//
//    public Integer updateUserType(Long id, User newUser) {
//        User originalUser = findUserById(id);
//
//        originalUser.setTeamMember(newUser.isTeamMember());
//
//        repository.save(originalUser);
//        return 1;
//    }
//
//    public Integer deleteUser(Long id) {
//        repository.deleteById(id);
//        return 1;
//    }
//
//    public Optional<User> findById(Long id) {
//        return repository.findById(id);
//    }

}
