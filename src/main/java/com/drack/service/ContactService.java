package com.drack.service;

import com.drack.dto.ContactDto;
import com.drack.persistence.entities.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();
    Optional<Contact> findById(Long id);
    Contact save(ContactDto contact);
    void deleteById(Long id);
    Contact update(Long id, ContactDto contact);
}
