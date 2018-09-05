package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.exeptions.UserNotFoundExeption;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User2;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.services.base.UserService;

import java.util.List;

@RestController
@RequestMapping("/springjwt/users2")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<User2> listAllUsers(){
        return userService.listAllUsers();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public User2 findById(@PathVariable("id") long id){
        return userService.findById(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public User2 updateUser(@RequestBody User2 updateUser, @PathVariable("id") long id){
        return userService.updateUser(id, updateUser);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return "Successfully deleted!";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public List<Product> listAllUserProducts(@PathVariable("id") long id){
        return userService.listAllProducts(id);
    }

    @ExceptionHandler(UserNotFoundExeption.class)
    public String catchUserNotFoundExeption(){
        return "User2 Not Found.";
    }
}
