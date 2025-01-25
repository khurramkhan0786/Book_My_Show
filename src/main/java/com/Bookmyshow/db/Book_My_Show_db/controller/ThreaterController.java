package com.Bookmyshow.db.Book_My_Show_db.controller;

import com.Bookmyshow.db.Book_My_Show_db.models.Threater;
import com.Bookmyshow.db.Book_My_Show_db.repository.ThreaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/threater")
public class ThreaterController {
    ThreaterRepository threaterRepository;

    @Autowired
    public ThreaterController(ThreaterRepository threaterRepository) {
        this.threaterRepository = threaterRepository;
    }

    @PostMapping("/create")
    public ResponseEntity createThreater(@RequestBody Threater threater) {
        threaterRepository.save(threater);
        return new ResponseEntity(threater, HttpStatus.CREATED);
    }
}
