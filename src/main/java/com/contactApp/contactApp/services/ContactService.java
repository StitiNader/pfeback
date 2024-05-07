package com.contactApp.contactApp.services;
import com.contactApp.contactApp.model.Contact;

public interface ContactService {
    void addContact(Contact contact);
    Contact getContactById(Integer id);
    void deleteContactById(Integer id);
    Contact updateContact(Contact updatedContact, Integer id);
}
