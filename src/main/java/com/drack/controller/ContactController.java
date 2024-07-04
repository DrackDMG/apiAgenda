package com.drack.controller;

import com.drack.dto.ContactDto;
import com.drack.persistence.entities.Contact;
import com.drack.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
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
    public ResponseEntity<Contact> save(@RequestBody ContactDto contact) {
        return ResponseEntity.status(201).body(contactService.save(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody ContactDto contact) {
        Contact contactU = contactService.update(id, contact);
        if (contactU == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contactU);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
