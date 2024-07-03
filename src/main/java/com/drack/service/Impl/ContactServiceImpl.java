package com.drack.service.Impl;

import com.drack.persistence.entities.Contact;
import com.drack.persistence.repository.ContactRepository;
import com.drack.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> findById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isEmpty()) {
            return null;
        }
        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            contactRepository.deleteById(id);
        }
    }

    @Override
    public Contact update(Long id, Contact contact) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isPresent()) {
            contactOptional.get().setName(contact.getName());
            contactOptional.get().setPhone(contact.getPhone());
            contactOptional.get().setEmail(contact.getEmail());
            return contactRepository.save(contactOptional.get());
        }
        return null;
    }
}
