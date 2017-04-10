package com.contactmanager.service;

import com.contactmanager.entity.Contact;

import java.util.List;

/**
 * Created by rbaranowski on 2016-04-11.
 */
public interface ContactService {
    public void add(Contact c);
    public List<Contact> list();
    public void delete(Contact c);
    public void update(Contact c);
    public Contact findById(int id);
}
