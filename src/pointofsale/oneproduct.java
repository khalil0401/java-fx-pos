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
     private SimpleStringProperty Code;
    private SimpleStringProperty Category;
    private SimpleStringProperty Type;
     private SimpleStringProperty Cost;
    private SimpleStringProperty Actions;

    public oneproduct(String Name, String Price, String Quantity, String Code, String Category, String Type, String Cost, String Actions) {
        this.Name=new SimpleStringProperty(Name); 
        this.Price=new SimpleStringProperty(Price);
        this.Quantity=new SimpleStringProperty(Quantity);
        this.Code=new SimpleStringProperty(Code);
        this.Category=new SimpleStringProperty(Category);
        this.Type=new SimpleStringProperty(Type);
        this.Cost=new SimpleStringProperty(Cost);
        this.Actions=new SimpleStringProperty(Actions);
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
     public String getCode() {
        return Code.get();
    }

    public String getCategory() {
        return Category.get();
    }

    public String getType() {
        return Type.get();
    }
     public String getCost() {
        return Cost.get();
    }

    public String getActions() {
        return Actions.get();
    }

    public void setQuantity(String Quantity) {
        this.Quantity.set(Quantity);
    }

   
    }