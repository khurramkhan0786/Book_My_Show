package com.Bookmyshow.experience.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class MailApiUtil {

    @Value("${mail.api.url}")
    String mailApiURL;

    public void sendUserRegistrationMail(String userName, String userEmail) {
        String url = mailApiURL + "/users/register" + "?email" + userEmail +"&userName" +userName;
        URI finalUrl = URI.create(url);
        RequestEntity req = RequestEntity.put(finalUrl).build();
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.PUT, req, String.class);
        }catch(Exception e){
            throw e;
        }
    }
}
