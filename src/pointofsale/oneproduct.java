/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author benchek
 */
public class oneproduct{
    private SimpleStringProperty Name;
    private SimpleStringProperty Price;
    private SimpleStringProperty Quantity;

    public oneproduct(String Name, String Price, String Quantity) {
        this.Name = new SimpleStringProperty(Name);
        this.Price = new SimpleStringProperty(Price);
        this.Quantity =  new SimpleStringProperty(Quantity);
    }

    public String getName() {
        return Name.get();
    }

    public String getPrice() {
        return Price.get();
    }

    public String getQuantity() {
        return Quantity.get();
    }
   

}