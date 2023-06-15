package com.example.cqrspractice.presentation.controller;

import com.example.cqrspractice.application.UserService;
import com.example.cqrspractice.domain.UserEntity;
import com.example.cqrspractice.infrastructure.UserQuery;
import com.example.cqrspractice.infrastructure.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserQuery userQuery;

    @Autowired
    public UserController(UserService userService, UserQuery userQuery) {
        this.userService = userService;
        this.userQuery = userQuery;
    }


    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userQuery.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{email}/password")
    public ResponseEntity<UserEntity> updatePassword(@PathVariable String email, @RequestBody String newPassword) {
        UserEntity userEntity = userService.updatePassword(email, newPassword);
        if (userEntity != null) {
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
