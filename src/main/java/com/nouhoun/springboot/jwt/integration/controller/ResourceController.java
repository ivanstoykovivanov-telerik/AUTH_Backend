package com.nouhoun.springboot.jwt.integration.controller;

import com.nouhoun.springboot.jwt.integration.domain.RandomCity;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/springjwt")
public class ResourceController {
    @Autowired
    private GenericService userService;

    @RequestMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<RandomCity> getUser(){
        return userService.findAllRandomCities();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }


    //ME
//   @PreAuthorize("hasAuthority('ADMIN_USER')")
    @PostMapping("/users/add")
    public User addUser( @RequestBody User user){
        System.out.println("**************");
        System.out.println(user.toString());
        System.out.println("**************");
        return userService.save(user);
    }

    //ME
    @PostMapping("/products/test")
    public User productTest( @RequestBody User user){
        System.out.println("**************");
        System.out.println(user.toString());
        System.out.println("**************");
        return userService.save(user);
    }
}
