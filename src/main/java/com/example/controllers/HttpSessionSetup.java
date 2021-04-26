package com.example.controllers;

import com.example.models.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HttpSessionSetup {
    List<User> users = new ArrayList<User>();

    @GetMapping("api/register/signup")
    public User register(
            @PathVariable("username") String username,
            @PathVariable("password") String password,
            @PathVariable("role") String role,
            HttpSession session) {
        User user = new User();
        user.setPassword(password);
        user.setUserName(username);
        user.setRole(role);
        session.setAttribute("currentUser", user);
        users.add(user);
        return user;
    }

//    @GetMapping("/api/users/profile")
//    public User profile(HttpSession session) {
//        User currentUser = (User) session.getAttribute("currentUser");
//        return currentUser;
//    }

    @GetMapping("/api/users/logout")
    public void logout (HttpSession session) {
        session.invalidate();
    }

    @GetMapping("/api/users/login")
    public User login(
            @PathVariable("username") String username,
            @PathVariable("password") String password,
            HttpSession session) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("currentUser", user);
                return user;
            }
        }
        return null;
    }
}
