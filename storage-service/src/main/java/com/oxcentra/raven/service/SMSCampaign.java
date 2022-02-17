package com.oxcentra.raven.service;

import com.oxcentra.raven.entity.Contacts;
import com.oxcentra.raven.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSCampaign implements CampaignService{

    @Autowired
    ContactsRepository contactsRepository;

    @Override
    public Iterable<Contacts> getAllContacts() {
        return contactsRepository.findAll();
    }

    @Override
    public Iterable<Contacts> findByTagsLike(String selectedTags) {
        return contactsRepository.findByTagsLike(selectedTags);
    }

}
