package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.serde.annotation.Serdeable;


@Serdeable
public class Contact
{
    /*
     * initial initialization class
     * */
    /*String name     ;
    String firstname;
    int    age      ;
    String email    ;
    String note     ;
    @JsonIgnore
    Object link     ;

    public Contact() {
    }

    public Contact(String name, String firstname, int age, String email, String note, Object link) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;
        this.email = email;
        this.note = note;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Object getLink() {
        return link;
    }

    public void setLink(Object link) {
        this.link = link;
    }*/


    /*
     * modify fields name, refactor structure
     * */
   /*String        firstname    ; // moved
    String        lastname     ; // renamed
    String        emailAddress ; // renamed
    String        supportNode  ; // renamed
    PostalAddress postalAddress; // new
//    @JsonIgnore
//    Object link     ;
    int           age          ; // moved

    public Contact(String name, String firstname, int age, String email, String note, Object link) {
        this.lastname = name;
        this.firstname = firstname;
        this.age = age;
        this.emailAddress = email;
        this.supportNode = note;
    }


    public Contact(String firstname, String lastname, String emailAddress, String supportNode, PostalAddress postalAddress, int age) {
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
    }*/


    /*
     * refactor field to Object
     * */
    Person person   ;
    String note     ;
    @JsonIgnore
    Object link     ;

    public Contact() {
    }

    public Contact(Person person, String note, Object link) {
        this.person = person;
        this.note = note;
        this.link = link;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Object getLink() {
        return link;
    }

    public void setLink(Object link) {
        this.link = link;
    }
}
