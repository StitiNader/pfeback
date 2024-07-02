package com.contactApp.contactApp.controller;

import com.contactApp.contactApp.dto.MessageResponse;
import com.contactApp.contactApp.model.Contact;
import com.contactApp.contactApp.services.ContactService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Contact>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getAllContacts());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Contact>> searchContact(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.searchContactsByName(name));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addContact(@RequestBody Contact contact) {
        //verification sur le champs num_tel
        if (Boolean.TRUE.equals(contactService.existsContactByNumTel(contact.getNumeroTel()))) {
            return ResponseEntity.badRequest().body(new MessageResponse("Num_tel Already Exist"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.addContact(contact));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact updatedContact, @PathVariable("id") Integer id) {
        Contact updatedContactResult = contactService.updateContact(updatedContact, id);
        return ResponseEntity.ok(updatedContactResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Integer id) {
        contactService.deleteContactById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<?> getContactById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getContactById(id));
    }

    @GetMapping("/contactbytel/{numTel}")
    public ResponseEntity<?> getContactByNum_tel(@PathVariable Integer numTel) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getContactByNumTel(numTel));
    }

}
