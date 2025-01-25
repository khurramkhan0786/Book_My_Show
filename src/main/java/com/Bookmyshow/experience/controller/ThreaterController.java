package com.Bookmyshow.experience.controller;

import com.Bookmyshow.experience.Requestbody.CreateThreaterRB;
import com.Bookmyshow.experience.dbresponse.Threater;
import com.Bookmyshow.experience.service.ThreaterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/exp/threater")
public class ThreaterController {

    private final ThreaterService threaterService;

    public ThreaterController(ThreaterService threaterService) {
        this.threaterService = threaterService;
    }

    @PostMapping("/create")
    public ResponseEntity createThreater(
            @RequestBody CreateThreaterRB createThreaterRB,
            @RequestParam UUID ownerUserId){
        //Request body -> threater details
        //Request Param -> ownerid
try{
    Threater threater = threaterService.createThreater(createThreaterRB, ownerUserId);
    return new ResponseEntity(threater, HttpStatus.CREATED);
     }catch (Exception e){
     return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}
