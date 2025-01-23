package com.Bookmyshow.mail.Book_My_Show_Mail.controller;

import com.Bookmyshow.mail.Book_My_Show_Mail.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail/user")
public class UserController {
   UserService userService;
   @Autowired
   public UserController(UserService userService) {
       this.userService = userService;
   }

    @PutMapping("/register")
    public ResponseEntity SendUserRegistrationMail(@RequestParam String email,@RequestParam String userName) {
       try{
           userService.sendUserRegistrationMail(email,userName);
           return new ResponseEntity("Mail Sent Successfully", HttpStatus.OK);
       }
       catch(Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
