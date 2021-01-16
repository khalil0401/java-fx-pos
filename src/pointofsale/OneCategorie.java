/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author benchek
 */
public class OneCategorie {
     private SimpleStringProperty code;
    private SimpleStringProperty name;
    private SimpleStringProperty image;
     private SimpleStringProperty id;

    public OneCategorie(String code, String name, String image, String id) {
        this.code =new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.image = new SimpleStringProperty(image);
        this.id = new SimpleStringProperty(id);
    }

    public String getCode() {
        return code.get();
    }

    public String getName() {
        return name.get();
    }

    public String getImage() {
        return image.get();
    }

    public String getId() {
        return id.get();
    }
    
}
