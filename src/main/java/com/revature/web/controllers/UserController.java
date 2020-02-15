package com.revature.web.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService service) {
        super();
        this.userService = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }
}
