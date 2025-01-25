package com.Bookmyshow.experience.service;

import com.Bookmyshow.experience.Exception.DatabaseInsertionException;
import com.Bookmyshow.experience.Requestbody.CreateUserRB;
import com.Bookmyshow.experience.dbresponse.AppUser;
import com.Bookmyshow.experience.dbresponse.Threater;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

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

    public AppUser getUserById(UUID id) {
        String url = dbApiUrl +"/user/"+id.toString();
        URI finalUrl = URI.create(url);
        RequestEntity request = RequestEntity.get(finalUrl).build();
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<AppUser> response = restTemplate.exchange(finalUrl, HttpMethod.GET, request, AppUser.class);
            return response.getBody();
        }catch(Exception e){
            throw e;
        }
    }
    public Threater createThreater(Threater threater) {
        //calling DB APi to save user
        String finalUrl = dbApiUrl + "/threater/create";
        URI url = URI.create(finalUrl);
        //create request Entity
        RequestEntity req = RequestEntity.post(url).body(threater);
        //Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<Threater> response = restTemplate.exchange(url, HttpMethod.POST, req, Threater.class);
            return response.getBody();
        }catch(Exception e){
            throw new DatabaseInsertionException(e.getMessage());
        }
    }


}
