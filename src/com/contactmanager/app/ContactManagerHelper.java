package com.contactmanager.app;

import com.contactmanager.entity.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    @FXML Label statusLabel;

    private static SessionFactory sessionFactory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            // A SessionFactory is set up once for an application!
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            System.out.println("registry: " + registry);
            try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
                System.out.println("sessionFactory " + sessionFactory + " created");
            }
            catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                System.out.println("sessionFactory NOT created");
                StandardServiceRegistryBuilder.destroy( registry );
            }
    }


    @FXML protected void handleAdd(ActionEvent e){
        if (nameInput.getText().isEmpty() || surnameInput.getText().isEmpty() || phoneInput.getText().isEmpty()){
            statusLabel.setText("Data not complete");
        } else {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save( new Contact(nameInput.getText(),surnameInput.getText(),phoneInput.getText()));
            session.getTransaction().commit();
            session.close();
        }
    }
}
