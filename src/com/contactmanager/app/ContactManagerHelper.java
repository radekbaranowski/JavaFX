package com.contactmanager.app;

import com.contactmanager.dao.ContactDAOImpl;
import com.contactmanager.entity.Contact;
import com.contactmanager.service.ContactService;
import com.contactmanager.service.ContactServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputControl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rbaranowski on 2016-04-07.
 */
public class ContactManagerHelper implements Initializable {
    @FXML TextInputControl nameInput;
    @FXML TextInputControl surnameInput;
    @FXML TextInputControl phoneInput;
    @FXML ListView contactList;
    @FXML TextInputControl ID;
    @FXML Label statusLabel;
    @FXML TextInputControl searchId;
    @FXML TextInputControl searchResult;


    private ContactService contactService=new ContactServiceImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            // A SessionFactory is set up once for an application!
        populateList();
    }

    @FXML protected void handleAdd(ActionEvent e){
        if (nameInput.getText().isEmpty() || surnameInput.getText().isEmpty() || phoneInput.getText().isEmpty()){
            statusLabel.setText("Data not complete");
        } else {
             contactService.add(new Contact(nameInput.getText(),surnameInput.getText(),phoneInput.getText()));
            populateList();
        }
    }

    @FXML protected void handleUpdate(ActionEvent e){
        if (nameInput.getText().isEmpty() || surnameInput.getText().isEmpty() || phoneInput.getText().isEmpty()){
            statusLabel.setText("Data incomplete");
        } else {
            statusLabel.setText("Trying to update");
            statusLabel.setText(String.valueOf(contactList.getEditingIndex()));
            contactService.update(contactService.findById(1));
            populateList();
        }
    }

    @FXML protected void handleDelete(ActionEvent e){
        if (nameInput.getText().isEmpty() || surnameInput.getText().isEmpty() || phoneInput.getText().isEmpty()){
            statusLabel.setText("Not implemented");
        } else {
            statusLabel.setText("Not implemented");
            contactService.delete(contactService.findById(1));
            populateList();
        }
    }

    @FXML protected void handleFindById(ActionEvent e){
        Contact sc = contactService.findById(Integer.parseInt(searchId.getText()));
        searchResult.setText(sc.getName()+ " " + sc.getSurname());
    }

    public void populateList(){
        ObservableList<String> ol = FXCollections.observableArrayList();
            contactService.list().forEach(c -> {
                ol.add(c.getId()+ " " + c.getPhoneNo()+ " " + c.getName() + " " + c.getSurname());
                System.out.println("Added to the list: " + c.getId()+ " " + c.getPhoneNo()+ " " + c.getName() + " " + c.getSurname() );
                });
        contactList.setItems(ol);
    }
}
