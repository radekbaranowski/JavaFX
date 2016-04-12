package com.contactmanager.service;

import com.contactmanager.dao.ContactDAO;
import com.contactmanager.dao.ContactDAOImpl;
import com.contactmanager.entity.Contact;

import java.util.List;

/**
 * Created by rbaranowski on 2016-04-11.
 */
public class ContactServiceImpl implements ContactService{

    private ContactDAO contactDAO=new ContactDAOImpl();

    public void add(Contact c){
        contactDAO.addContact(c);
    };

    public List<Contact> list(){
        return contactDAO.listContacts();
    };
    public void delete(Contact c){
        contactDAO.removeContact(c);
    };
    public void update(Contact c){
        contactDAO.updateContact(c);
    };
}
