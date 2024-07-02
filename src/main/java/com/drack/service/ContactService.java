package com.drack.service;

import com.drack.persistence.entities.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact contact);
    void deleteById(Long id);
}
