package com.oxcentra.raven.service;

import com.oxcentra.raven.entity.Contacts;


public interface CampaignService {

    Iterable<Contacts> getAllContacts();
    Iterable<Contacts> findByTagsLike(String selectedTags);
}
