package com.contactApp.contactApp.services.impl;

import com.contactApp.contactApp.model.Contact;
import com.contactApp.contactApp.repository.ContactRepository;
import com.contactApp.contactApp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact updateContact(Contact updatedContact, Integer id) {
        // Vérifier si le contact avec l'ID donné existe
        Optional<Contact> existingContactOptional = contactRepository.findById(id);
        return updatedContact;
    }

    public void deleteContactById(Integer id) {
        contactRepository.deleteById(id);
    }
    @Override
    public Contact getContactById(Integer id) {
        return null;
    }




}