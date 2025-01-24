package com.Bookmyshow.experience.Requestbody;


public class CreateUserRB {
    String name;
    String email;
    String password;
    Long ContactNumber;
    String UserType;

    public CreateUserRB(String name, String email, String password, Long contactNumber, String userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        ContactNumber = contactNumber;
        UserType = userType;
    }

    public CreateUserRB() {
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
