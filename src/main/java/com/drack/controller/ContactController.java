package com.drack.controller;

import com.drack.persistence.entities.Contact;
import com.drack.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        return ResponseEntity.ok(contactService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contact>> findById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.findById(id);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contact);
    }

    @PostMapping
    public ResponseEntity<Contact> save(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.save(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact contact) {
        Optional<Contact> contactOptional = contactService.findById(id);
        if (contactOptional != null) {
            contact.setId(id);
            return ResponseEntity.ok(contactService.save(contact));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.findById(id);
        if (contact != null) {
            contactService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
