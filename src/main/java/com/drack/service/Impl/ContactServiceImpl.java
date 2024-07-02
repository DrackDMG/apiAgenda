package com.drack.service.Impl;

import com.drack.persistence.entities.Contact;
import com.drack.persistence.repository.ContactRepository;
import com.drack.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
