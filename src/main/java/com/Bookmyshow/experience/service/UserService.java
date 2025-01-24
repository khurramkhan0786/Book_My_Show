package com.Bookmyshow.experience.service;

import com.Bookmyshow.experience.Requestbody.CreateUserRB;
import com.Bookmyshow.experience.util.MailApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    DatabaseAPIUtil databaseAPIUtil;

    @Autowired
    MailApiUtil mailApiUtil;

    UserService(DatabaseAPIUtil databaseAPIUtil ,MailApiUtil mailApiUtil) {
        this.databaseAPIUtil = databaseAPIUtil;
        this.mailApiUtil = mailApiUtil;
    }
    public void createUser(CreateUserRB createUserRB) {
        //Call DB ApI
        try{
            databaseAPIUtil.createuser(createUserRB);

        }catch (Exception e) {
            throw e;
        }

        try{
            mailApiUtil.sendUserRegistrationMail(createUserRB.getEmail(), createUserRB.getName());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
