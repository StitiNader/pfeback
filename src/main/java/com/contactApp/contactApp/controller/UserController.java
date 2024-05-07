package com.contactApp.contactApp.controller;

import com.contactApp.contactApp.model.App_User;
import com.contactApp.contactApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody App_User user) {
        userService.addUser(user);

        return "success add user";
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody App_User user) {
        userService.updateUser(user);
        return "success update user";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "success delete user";
    }
    @GetMapping("/users/{id}")
    public App_User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }
}
