package com.Bookmyshow.experience.service;

import com.Bookmyshow.experience.Exception.DatabaseInsertionException;
import com.Bookmyshow.experience.Requestbody.CreateUserRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class DatabaseAPIUtil {

    @Value(value = "${db.api.url}")
    String dbApiUrl;




    public void createuser(CreateUserRB createUserRB) {
        //calling DB APi to save user
        String finalUrl = dbApiUrl + "/user/create";
        URI url = URI.create(finalUrl);
        //create request Entity
        RequestEntity req = RequestEntity.post(url).body(createUserRB);
        //Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, req, String.class);

        }catch(Exception e){
                throw new DatabaseInsertionException("Database Insertion Failed");
        }
    }
}
