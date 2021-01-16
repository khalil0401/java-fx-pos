/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import com.sun.deploy.util.FXLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class LoginController implements Initializable {

    @FXML
    private TextField text_username;
    @FXML
    private PasswordField text_password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void loginaction(ActionEvent event) {
        JdbcDao dao =new JdbcDao();
        boolean v=dao.validate(text_username.getText().toString(), text_password.getText().toString());
        System.err.println(v);
        if(v){
            try{
                FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
               Stage stage1=(Stage) text_username.getScene().getWindow();
               stage1.close();
            }catch(Exception e){
                
            }
        }else{
        
            
    }
    }
    
}
