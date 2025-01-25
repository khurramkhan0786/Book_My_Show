package com.Bookmyshow.db.Book_My_Show_db.models;

import jakarta.persistence.*;


import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    @Column(unique=true, nullable=false)
    String email;
    @Column(nullable=false)
    String password;
    @Column(name = "contact_number", unique = true)
    private Long ContactNumber;

    @Column(name = "user_type")
    private String UserType;

    public AppUser() {
    }

    public AppUser(UUID id, String name, String email, String password, Long contactNumber, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        ContactNumber = contactNumber;
        UserType = userType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }
}
