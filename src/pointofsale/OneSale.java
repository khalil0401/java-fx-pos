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
public class OneSale {

    private SimpleStringProperty ID;
    private SimpleStringProperty NameCustomer;
    private SimpleStringProperty Date;
    private SimpleStringProperty Total;
    private SimpleStringProperty Paid;
    private SimpleStringProperty Status;
    private HBox Action;
    private Button Action1;
    public OneSale(String ID, String NameCustomer, String Date, String Total, String Paid, String Status ) {
        this.ID = new SimpleStringProperty(ID);
        this.NameCustomer = new SimpleStringProperty(NameCustomer);
        this.Date = new SimpleStringProperty(Date);
        this.Total = new SimpleStringProperty(Total);
        this.Paid = new SimpleStringProperty(Paid);
        this.Status = new SimpleStringProperty(Status);
        Button Edit =new Button("Edit"); Button Delete =new Button("Delete");
        this.Action=new HBox(Edit,Delete);
        Edit.setOnAction(this::handelButtonActionEdit);
         Delete.setOnAction(this::handelButtonActionDelete);
    }

    public Button getAction1() {
        return Action1;
    }

    public void setAction1(Button Action1) {
        this.Action1 = Action1;
    }

    public HBox getAction() {
        return Action;
    }

    public void setAction(HBox Action) {
        this.Action = Action;
    }

    public void setID(SimpleStringProperty ID) {
        this.ID = ID;
    }

    public void setNameCustomer(SimpleStringProperty NameCustomer) {
        this.NameCustomer = NameCustomer;
    }

    public void setDate(SimpleStringProperty Date) {
        this.Date = Date;
    }

    public void setTotal(SimpleStringProperty Total) {
        this.Total = Total;
    }

    public void setPaid(SimpleStringProperty Paid) {
        this.Paid = Paid;
    }

    public void setStatus(SimpleStringProperty Status) {
        this.Status = Status;
    }

    public String getID() {
        return ID.get();
    }

    public String getNameCustomer() {
        return NameCustomer.get();
    }

    public String getDate() {
        return Date.get();
    }

    public String getTotal() {
        return Total.get();
    }

    public String getPaid() {
        return Paid.get();
    }

    public String getStatus() {
        return Status.get();
    }
    public  void handelButtonActionEdit(Event event){
       
        System.err.println("******EDIT******"+getID());
    }
     public  void handelButtonActionDelete(Event event){
       
        System.err.println("****DELTE********"+getID());
    }
}
