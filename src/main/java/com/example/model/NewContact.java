package com.example.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class NewContact {
    String        firstname    ; // moved
    String        lastname     ; // renamed
    String        emailAddress ; // renamed
    String        supportNode  ; // renamed
    PostalAddress postalAddress; // new
    int           age          ; // moved

    public NewContact(String firstname, String lastname, String emailAddress, String supportNode, PostalAddress postalAddress, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.supportNode = supportNode;
        this.postalAddress = postalAddress;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSupportNode() {
        return supportNode;
    }

    public void setSupportNode(String supportNode) {
        this.supportNode = supportNode;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
