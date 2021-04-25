package com.example.controllers;

import com.example.models.User;
import com.example.services.MatchService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MatchController {
    @Autowired
    MatchService service ;

    @PostMapping("/api/login")
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

    @PutMapping("/api/users/{uid}/{userName}")
    public Integer updateUsername(
            @PathVariable("uid") Long id,
            @RequestBody User user) {
        return service.updateUsername(id, user);
    }

    @PutMapping("/api/users/{uid}/{password}")
    public Integer updatePassword(
            @PathVariable("uid") Long id,
            @RequestBody User user) {
        return service.updatePassword(id, user);
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

}
