package com.contactmanager.dao;

import com.contactmanager.entity.Contact;
import com.contactmanager.entity.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbaranowski on 2016-04-08.
 */
public class ContactDAOImpl implements ContactDAO {
    @Override
    public void addContact(Contact contact){
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.save(contact);
        session.getTransaction().commit();
        session.close();
    };
    @Override
    public List<Contact> listContacts(){
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        List<Contact> list = session.createQuery("from Contact").list();
        System.out.println("contacts retrieved: " + list.size());
        session.getTransaction().commit();
        session.close();
        return list;
    };
    @Override
    public void removeContact(Contact contact){
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.delete("from CONTACTS",contact);
        session.getTransaction().commit();
        session.close();

    };
    @Override
    public void updateContact(Contact contact){
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        System.out.println(contact);
        session.update(contact);
        session.getTransaction().commit();
        session.close();
    };

    @Override
    public Contact findById(int id){
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Query   q = session.createQuery("from Contact where CONTACT_ID = :id");
                q.setParameter("id",id);
        List<Contact> list = q.list();
        System.out.println("contacts retrieved: " + list.size());
        session.getTransaction().commit();
        session.close();
        return !list.isEmpty() ? list.get(0) : null ;
    };

}
