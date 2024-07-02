package com.contactApp.contactApp.services;

import com.contactApp.contactApp.model.Contact;

import java.util.List;

public interface ContactService {
    Contact addContact(Contact contact);

    Contact getContactById(Integer id);

    boolean existsContactByNumTel(int numTel);

    Contact getContactByNumTel(int numTel);

    void deleteContactById(Integer id);

    List<Contact> searchContactsByName(String name);

    Contact updateContact(Contact updatedContact, Integer id);

    List<Contact> getAllContacts();
}
