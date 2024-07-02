package com.drack.service;

import com.drack.persistence.entities.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();
    Optional<Contact> findById(Long id);
    Contact save(Contact contact);
    void deleteById(Long id);
}
