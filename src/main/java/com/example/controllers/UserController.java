package com.example.controllers;

import com.example.models.Match;
import com.example.models.User;
import com.example.repositories.UserRepository;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
    @Autowired
    UserService service ;

    @PostMapping("/api/users/login")
    public User login(@RequestBody User credentials,
                      HttpSession session) {
        User existingUser = service.findUserByCredentials(
                credentials.getUserName(),
                credentials.getPassword()
        );
        if(existingUser != null) {
            session.setAttribute("profile", existingUser);
            return existingUser;
        }
        return null;
    }

    @PostMapping("/api/users/signup")
    public User signup(@RequestBody User newUser, HttpSession session) {
        User existingUser = service.findUserByUsername(newUser.getUserName());
        if(existingUser == null) {
            newUser = service.createUser(newUser);
            session.setAttribute("profile", newUser);
        }
        return null;
    }

    @PutMapping("/api/users/profile/{id}")
    public Integer updateProfile(
            @PathVariable("id") Long id,
            @RequestBody User user) {
        return service.updateProfile(id, user);
    }


    @PutMapping("/api/users/{uid}/{teamMember}")
    public Integer updateTeamMember(
            @PathVariable("uid") Long id,
            @RequestBody User user) {
        return service.updateUserType(id, user);
    }

    @GetMapping("/api/users/profile")
    public User profile(HttpSession session) {
        return (User) session.getAttribute("profile");
    }

    @GetMapping("/api/profile/{userId}")
    public User profile(@PathVariable("userId") Long id) {
        return service.findById(id).get();
    }

//    @PostMapping("/api/users/{uid}/comments")
//    public Match addComment(@PathVariable("uid") Long id, @RequestBody Match match) {
//        User existingUser = service.findUserById(id);
//        existingUser.setMatch(match);
//        return null;
//    }



}
