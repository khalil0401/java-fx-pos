/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author benchek
 */
public class OneCustomer {
    private SimpleStringProperty ID;
    private SimpleStringProperty name;
    private SimpleStringProperty Phone;
     private SimpleStringProperty Email;

    public OneCustomer(String ID, String name, String Phone, String Email) {
        this.ID =new SimpleStringProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.Phone = new SimpleStringProperty(Phone);
        this.Email = new SimpleStringProperty(Email);
    }

    public String getID() {
        return ID.get();
    }

    public String getName() {
        return name.get();
    }

    public String getPhone() {
        return Phone.get();
    }

    public String getEmail() {
        return Email.get();
    }   
}
