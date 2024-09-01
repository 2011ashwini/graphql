package com.example.graphql.controller;

import com.example.graphql.entity.UserEntity;
import com.example.graphql.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
        UserEntity savedUser = userService.saveUserEntity(user);
        return ResponseEntity.ok(savedUser);

    }
}
