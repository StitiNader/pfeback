package com.contactApp.contactApp.controller;

import com.contactApp.contactApp.model.Contact;
import com.contactApp.contactApp.model.App_User;
import com.contactApp.contactApp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public String addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);

        return "success add contact";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact updatedContact, @PathVariable("id") Integer id) {
        Contact updatedContactResult = contactService.updateContact(updatedContact, id);
        return ResponseEntity.ok(updatedContactResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Integer id) {
        contactService.deleteContactById(id);
        return ResponseEntity.ok("Contact deleted successfully");
    }

    @GetMapping("/contacts/{id}")
    public Contact getContactById(@PathVariable Integer id) {
        return contactService.getContactById(id);
    }

}
