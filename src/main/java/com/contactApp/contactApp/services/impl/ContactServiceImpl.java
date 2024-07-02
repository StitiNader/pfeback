package com.contactApp.contactApp.services.impl;

import com.contactApp.contactApp.model.Contact;
import com.contactApp.contactApp.repository.ContactRepository;
import com.contactApp.contactApp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact updatedContact, Integer id) {
        getContactById(id);
        updatedContact.setId(id);
        return contactRepository.save(updatedContact);
    }

    public void deleteContactById(Integer id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> searchContactsByName(String name) {
        return contactRepository.findContactsByNomContainingIgnoreCase(name);
    }

    @Override
    public Contact getContactById(Integer id) {
        return contactRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Contact not found"));
    }

    @Override
    public boolean existsContactByNumTel(int numTel) {
        return contactRepository.existsByNumeroTel(numTel);
    }

    @Override
    public Contact getContactByNumTel(int numTel) {
        return contactRepository.findByNumeroTel(numTel);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


}