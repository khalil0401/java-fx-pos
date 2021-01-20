/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author benchek
 */
public class OneUser {
    private SimpleStringProperty ID;
    private SimpleStringProperty Username;
    private SimpleStringProperty Email;
    private SimpleStringProperty Firstname;
    private SimpleStringProperty Lastname;
    private SimpleStringProperty Status;
    private SimpleStringProperty Group;
    private HBox Actions;

    public OneUser(String ID, String Username, String Email, String Firstname, String Lastname, String Status, String Group) {
        this.ID = new SimpleStringProperty(ID);
        this.Username = new SimpleStringProperty(Username);
        this.Email = new SimpleStringProperty(Email);
        this.Firstname = new SimpleStringProperty(Firstname);
        this.Lastname = new SimpleStringProperty(Lastname);
        this.Status = new SimpleStringProperty(Status);
        this.Group = new SimpleStringProperty(Group);
        Button Edit =new Button("Edit"); Button Delete =new Button("Delete");
        this.Actions=new HBox(Edit,Delete);
        Edit.setOnAction(this::handelButtonActionEdit);
         Delete.setOnAction(this::handelButtonActionDelete);
    }

    public void setActions(HBox Actions) {
        this.Actions = Actions;
    }

    public HBox getActions() {
        return Actions;
    }

    public void setID(SimpleStringProperty ID) {
        this.ID = ID;
    }

    public void setUsername(SimpleStringProperty Username) {
        this.Username = Username;
    }

    public void setEmail(SimpleStringProperty Email) {
        this.Email = Email;
    }

    public void setFirstname(SimpleStringProperty Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastname(SimpleStringProperty Lastname) {
        this.Lastname = Lastname;
    }

    public void setStatus(SimpleStringProperty Status) {
        this.Status = Status;
    }

    public void setGroup(SimpleStringProperty Group) {
        this.Group = Group;
    }

    public String getID() {
        return ID.get();
    }

    public String getUsername() {
        return Username.get();
    }

    public String getEmail() {
        return Email.get();
    }

    public String getFirstname() {
        return Firstname.get();
    }

    public String getLastname() {
        return Lastname.get();
    }

    public String getStatus() {
        return Status.get();
    }

    public String getGroup() {
        return Group.get();
    }
     public  void handelButtonActionEdit(Event event){
       
        System.err.println("******EDIT******"+getID());
    }
     public  void handelButtonActionDelete(Event event){
       
        System.err.println("****DELTE********"+getID());
    }
    
    
}
