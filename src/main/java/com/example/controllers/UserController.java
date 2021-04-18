package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/api/users/signup")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
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



}
