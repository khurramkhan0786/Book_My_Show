package com.Bookmyshow.mail.Book_My_Show_Mail.service;

import com.Bookmyshow.mail.Book_My_Show_Mail.requestbody.Threater;
import com.Bookmyshow.mail.Book_My_Show_Mail.utility.MailUtility;
import org.springframework.stereotype.Service;

@Service
public class ThreaterService {
    MailUtility mailUtility;


  public void sendThreaterRegistrationMail(Threater threater) throws Exception {
      String toEmail= threater.getOwner().getEmail();
      String address = threater.getAddress();
      String subjectLine = "Threater Registration Successful";
     mailUtility.sendThreaterRegistrationMail(threater.getOwner().getName(),address,toEmail,subjectLine);
  }
}
