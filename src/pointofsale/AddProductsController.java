package pointofsale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert; 
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class AddProductsController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private ComboBox<String> Type;
    @FXML
    private TextField Code;
    @FXML
    private ComboBox<String> Category;
    @FXML
    private TextField Cost;
    @FXML
    private TextField Price;
    @FXML
    private TextField Alert_Quantity;
    @FXML
    private TextField Image;
    @FXML
    private TextArea Details;
    @FXML
    private TextField Quantity;
    JdbcDao dao=new JdbcDao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Type.getItems().add("أساسي");
        try {
            ResultSet resultSetcat= dao.GetCat();
             while(resultSetcat.next()){
        Category.getItems().add(resultSetcat.getString("name"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(AddProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }    

    @FXML
    private void AddProduct(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(!Name.getText().equals("")&!Price.getText().equals("")&!Quantity.getText().equals("")&!Code.getText().equals("")&!Cost.getText().equals("")&!Alert_Quantity.getText().equals("")){
         try{
        dao.InsertProducts(Name.getText(), Float.parseFloat(Price.getText()), Integer.valueOf( Quantity.getText()), Code.getText(),1, Type.getSelectionModel().getSelectedItem(),Float.parseFloat( Cost.getText()), Integer.valueOf(Alert_Quantity.getText()), Image.getText(), Details.getText());
        Stage stage1 = (Stage) Name.getScene().getWindow();
                stage1.close();
         }catch(Exception e){
             alert.setContentText("خطاء في المدخلات");
             alert.show();
         }
        }else{
           alert.setContentText("الرجاء ملء كل الحقول");
          alert.show();

        }
    }
    
}
