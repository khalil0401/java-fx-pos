/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import javafx.collections.ObservableList;

/**
 *
 * @author benchek
 */
public class PaidObject {
   private ObservableList<oneproduct> totalobject;
   private String total;
   private int IdCustomer;
 private String CustomerName;
    public PaidObject(int IdCustomer,String CustomerName,ObservableList<oneproduct> totalobject, String total) {
        this.totalobject = totalobject;
        this.total = total;
        this.IdCustomer=IdCustomer;
         this.CustomerName=CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(int IdCustomer) {
        this.IdCustomer = IdCustomer;
    }
   
    public ObservableList<oneproduct> getTotalobject() {
        return totalobject;
    }

    public void setTotalobject(ObservableList<oneproduct> totalobject) {
        this.totalobject = totalobject;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
     
    
}
