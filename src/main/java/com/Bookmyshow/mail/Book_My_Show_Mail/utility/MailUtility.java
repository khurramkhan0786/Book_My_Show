package com.Bookmyshow.mail.Book_My_Show_Mail.utility;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;



@Service
public class MailUtility {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    public void sendMail(String subjectLine,String mailType,String toEmail, String userName) throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        Context context = new Context();
        context.setVariable("userName", userName);
          mimeMessageHelper.setSubject(subjectLine);
          mimeMessageHelper.setTo(toEmail);
//          TemplateEngine templateEngine = new TemplateEngine();
          String htmlEmail = templateEngine.process("user_registration_mail",context);
          mimeMessageHelper.setText(htmlEmail,true);
          javaMailSender.send(mimeMessage);

    }

    public void sendThreaterRegistrationMail(String ownerName, String address,String toEmail, String subjectLine)throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        Context context = new Context();
        context.setVariable("userName", ownerName);
        context.setVariable("address", address);
        mimeMessageHelper.setSubject(subjectLine);
        mimeMessageHelper.setTo(toEmail);
//          TemplateEngine templateEngine = new TemplateEngine();
        String htmlEmail = templateEngine.process("threater_registration_mail",context);
        mimeMessageHelper.setText(htmlEmail,true);
        javaMailSender.send(mimeMessage);

    }

}
