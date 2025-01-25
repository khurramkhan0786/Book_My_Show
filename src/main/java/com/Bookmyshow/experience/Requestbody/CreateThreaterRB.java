package com.Bookmyshow.experience.Requestbody;

import org.springframework.stereotype.Service;

public class CreateThreaterRB {

    Long helpLineNumber;
    String address;

    public CreateThreaterRB(Long helpLineNumber, String address) {
        this.helpLineNumber = helpLineNumber;
        this.address = address;
    }

    public Long getHelpLineNumber() {
        return helpLineNumber;
    }

    public CreateThreaterRB() {
    }

    public void setHelpLineNumber(Long helpLineNumber) {
        this.helpLineNumber = helpLineNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
