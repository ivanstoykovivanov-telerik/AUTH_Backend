package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.UserDTO;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.services.base.UserService;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseBody
    public User registerUser(@RequestBody UserDTO user) {
        return userService.addUser(user);
    }
}
