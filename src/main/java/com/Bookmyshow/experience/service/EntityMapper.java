package com.Bookmyshow.experience.service;

import com.Bookmyshow.experience.Requestbody.CreateThreaterRB;
import com.Bookmyshow.experience.dbresponse.AppUser;
import com.Bookmyshow.experience.dbresponse.Threater;
import org.springframework.stereotype.Service;

@Service
public class EntityMapper {

    public Threater convertThreaterRBToThreaterModel(CreateThreaterRB createThreaterRB , AppUser owner) {
   Threater threater = new Threater();
   threater.setOwner(owner);
   threater.setAddress(createThreaterRB.getAddress());
   threater.setThreaterHelpLine(createThreaterRB.getHelpLineNumber());

//            Threater threater = Threater.builder().address(createThreaterRB.getAddress())
//                    .threaterHelpLine(createThreaterRB.getHelpLineNumber())
//                    .owner(owner)
//                    .build();
          return threater;

        }
}
