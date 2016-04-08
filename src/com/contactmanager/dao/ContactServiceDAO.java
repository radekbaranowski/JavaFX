package com.contactmanager.dao;

import com.contactmanager.entity.Contact;

import java.util.List;

/**
 * Created by rbaranowski on 2016-04-08.
 */
public interface ContactServiceDAO {
    public void addContact(Contact contact);
    public List<Contact> listContacts();
}
