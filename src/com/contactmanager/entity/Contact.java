package com.contactmanager.entity;

import java.util.Date;

/**
 * Created by rbaranowski on 2016-04-07.
 */
public class Contact {

    private Long id;


    private String name;
    private String surname;
    private String phoneNo;

    public Contact() {
        // this form used by Hibernate
    }

    public Contact(String name, String surname, String phoneNo) {
        // for application use, to create new events
        this.name = name;
        this.surname = surname;
        this.phoneNo = phoneNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id ; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }



}
