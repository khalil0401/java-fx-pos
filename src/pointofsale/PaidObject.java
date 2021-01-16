/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author benchek
 */
public class PaidObject {
   private String totalobject;
   private String total;

    public PaidObject(String totalobject, String total) {
        this.totalobject = totalobject;
        this.total = total;
    }
   
    public String getTotalobject() {
        return totalobject;
    }

    public void setTotalobject(String totalobject) {
        this.totalobject = totalobject;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
     
    
}
