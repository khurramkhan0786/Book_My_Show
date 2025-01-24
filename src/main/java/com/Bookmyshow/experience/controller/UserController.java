package com.Bookmyshow.experience.controller;

import com.Bookmyshow.experience.Exception.DatabaseInsertionException;
import com.Bookmyshow.experience.Requestbody.CreateUserRB;
import com.Bookmyshow.experience.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exp/user")
public class UserController {

    UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody CreateUserRB createUserRB){
    try{
        userService.createUser(createUserRB);
     return new ResponseEntity("User Create Successfully" ,HttpStatus.CREATED);
    }
    catch(DatabaseInsertionException databaseInsertionException){
        return new ResponseEntity<>(databaseInsertionException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

       }
    }
}
