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
public class OneReportProduct {
    private SimpleStringProperty ID;
    private SimpleStringProperty Name;
    private SimpleStringProperty Price;
    private SimpleStringProperty Profit;
     private SimpleStringProperty Code;
    private SimpleStringProperty NumberPieces;
    private SimpleStringProperty Type;
     private SimpleStringProperty Cost;
    private SimpleStringProperty Actions;

    public OneReportProduct(String ID ,String Name, String Price, String Profit, String Code, String NumberPieces, String Type, String Cost, String Actions) {
         this.ID=new SimpleStringProperty(ID); 
        this.Name=new SimpleStringProperty(Name); 
        this.Price=new SimpleStringProperty(Price);
        this.Profit=new SimpleStringProperty(Profit);
        this.Code=new SimpleStringProperty(Code);
        this.NumberPieces=new SimpleStringProperty(NumberPieces);
        this.Type=new SimpleStringProperty(Type);
        this.Cost=new SimpleStringProperty(Cost);
        this.Actions=new SimpleStringProperty(Actions);
    }
      public void setID(SimpleStringProperty ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getPrice() {
        return Price.get();
    }

    public String getProfit() {
        return Profit.get();
    }
     public String getCode() {
        return Code.get();
    }

    public String getNumberPieces() {
        return NumberPieces.get();
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

    public void setProfit(String Profit) {
        this.Profit.set(Profit);
    }
    
}
