package com.example.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Person {
    String name     ;
    String firstname;
    int    age      ;
    String email    ;

    public Person() {
    }

    public Person(final String name,final String firstname,final int age,final String email) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;
        this.email = email;
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
}
