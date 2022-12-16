package com.example.controller;

import com.example.database.DB;
import com.example.model.Contact;
import com.example.model.NewContact;
import com.example.model.PostalAddress;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("contacts")
public class MainController {
//    @Get("initData")
//    public HttpResponse<String> init() {
//        DB.getRoot().getContacts().clear();
//        for (int i = 0; i < 20; i++) {
//            Contact contact = new Contact("randomName" + i, "randomFirstname" + i,
//                    20 + i, "randomEmail" + i + "@g.c", "Amazing note", new Object());
//            DB.getRoot().getContacts().add(contact);
//        }
//
//        DB.getInstance().store(DB.getRoot().getContacts());
//        return HttpResponse.ok("Contacts successfully created!");
//    }
//    @Get("testAddNewContact")
//    public HttpResponse<String> testAdd() {
//
//            Contact contact = new Contact("randomName" + 40, "randomFirstname" + 40,
//                     "randomEmail" + 40 + "@g.c", "Amazing note", new PostalAddress(), 40);
//            DB.getRoot().getContacts().add(contact);
//
//        DB.getInstance().store(DB.getRoot().getContacts());
//        return HttpResponse.ok("Contact successfully add!");
//    }
    @Get
    public List<Contact> getContact()
    {
        return DB.getRoot().getContacts();
    }
//    @Get
//    public List<NewContact> getContact()
//    {
//        return DB.getRoot().getContacts();
//    }
}
