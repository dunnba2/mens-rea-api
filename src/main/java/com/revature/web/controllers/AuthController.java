package com.revature.web.controllers;

import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService service) {
        super();
        this.userService = service;
    }


}
