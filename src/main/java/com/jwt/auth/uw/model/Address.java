package com.jwt.auth.uw.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address {
    private static final long serialVersionUID = 1L;


    @Column(name = "add_address")
    private String addAddress;

    @Column(name = "phy_address")
    private String phyAddress;

    @Column(name = "add_email_addr")
    private String emailAddress;


    public Address() {
    }


    public String getAddAddress() {
        return this.addAddress;
    }

    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getPhyAddress() {
        return phyAddress;
    }


    public void setPhyAddress(String phyAddress) {
        this.phyAddress = phyAddress;
    }
}






