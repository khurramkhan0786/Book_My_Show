package com.Bookmyshow.experience.service;

import com.Bookmyshow.experience.Exception.InvalidUser;
import com.Bookmyshow.experience.Requestbody.CreateThreaterRB;
import com.Bookmyshow.experience.dbresponse.AppUser;
import com.Bookmyshow.experience.dbresponse.Threater;
import com.Bookmyshow.experience.util.MailApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThreaterService {
    @Autowired
    EntityMapper entityMapper;
    DatabaseAPIUtil databaseAPI;
    @Autowired
    MailApiUtil mailApiUtil;

    @Autowired
    public ThreaterService(DatabaseAPIUtil databaseAPIUtil, EntityMapper entityMapper) {
        this.databaseAPI = databaseAPIUtil;
        this.entityMapper = entityMapper;
    }


    public Threater createThreater(CreateThreaterRB createThreaterRB, UUID ownerUserID){
        //Is userID exist in System or  not
        //if UserId exists then we need to verify type of user
        // Call DBAPi to provide User object on the basis of UserId we are passing
        AppUser user = databaseAPI.getUserById(ownerUserID);
        if(user.getUserType().equals("ThreaterOwner")){
            //Exception throw
            throw new InvalidUser(String.format("User with id %s does not have access to create threater ",ownerUserID.toString()));
        }
        //if you don't come inside if condition that user is a threater owner
        //experience Api will call database api to create threater is database
        Threater threater = entityMapper.convertThreaterRBToThreaterModel(createThreaterRB,user);
        Threater respThreater = databaseAPI.createThreater(threater);
        //call mail api to notify that his threater got registor
        mailApiUtil.sendThreaterRegistrationMail(threater);
        return respThreater;
    }
}
