package com.Bookmyshow.mail.Book_My_Show_Mail.controller;

import com.Bookmyshow.mail.Book_My_Show_Mail.requestbody.Threater;
import com.Bookmyshow.mail.Book_My_Show_Mail.service.ThreaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail/threater")
public class ThreaterController {
    @Autowired
    ThreaterService threaterService;


    @PutMapping("/create")
    public ResponseEntity sendthreaterRegistrationMail(@RequestBody Threater threater) {
        try{
            threaterService.sendThreaterRegistrationMail(threater);
            return new ResponseEntity("Mail Sent", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity("Mail Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
