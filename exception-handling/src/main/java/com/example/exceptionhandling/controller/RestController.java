package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.model.User;
import com.example.exceptionhandling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
   public ResponseEntity<User> addUser(@RequestBody User user)
    {
        User user1=userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/seeUser")
    public ResponseEntity<List<User>> seeUser()
    {
        List<User>allUser=userService.seeUser();
        return new ResponseEntity<>(allUser,HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id)
    {
        User user=userService.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }
}
