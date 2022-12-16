package com.example.database;

import com.example.model.Contact;
import com.example.model.NewContact;

import java.util.ArrayList;
import java.util.List;

public class DataRoot {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts()
    {
        return contacts;
    }


}
