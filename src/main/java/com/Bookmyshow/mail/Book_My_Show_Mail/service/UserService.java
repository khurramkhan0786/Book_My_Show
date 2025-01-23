package com.Bookmyshow.mail.Book_My_Show_Mail.service;

import com.Bookmyshow.mail.Book_My_Show_Mail.utility.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    MailUtility mailUtility;
       @Autowired
       public UserService(MailUtility mailUtility) {
           this.mailUtility = mailUtility;
       }
    public void sendUserRegistrationMail(String email,String userName) throws Exception{
    mailUtility.sendMail("welcome To book My Show!!",
            "User Registration",
            email,userName);
    }
}
