package com.contactmanager.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by rbaranowski on 2016-04-08.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final StandardServiceRegistry serviceRegistry;

    static {
        try{
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            System.out.println("registry: " + serviceRegistry);
            sessionFactory = new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();
            System.out.println("sessionFactory " + sessionFactory + " created");
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

}
