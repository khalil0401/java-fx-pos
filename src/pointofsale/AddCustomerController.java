package pointofsale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class AddCustomerController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Email;
    @FXML
    private TextField Phone;
    JdbcDao dao=new JdbcDao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddCustomerAction(ActionEvent event) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(!Name.getText().equals("")){
         try{
        dao.InsertCustomer(Name.getText(),Phone.getText(),Email.getText());
         }catch(Exception e){
             alert.setContentText("خطاء في المدخلات "+e);
             alert.show();
         }
        }else{
           alert.setContentText("الرجاء ملء كل الحقول");
          alert.show();

        }
    }
    
}
