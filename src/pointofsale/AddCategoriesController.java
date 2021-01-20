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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class AddCategoriesController implements Initializable {

    @FXML
    private TextField Code;
    @FXML
    private TextField Name;
    @FXML
    private TextField Image;
    JdbcDao dao =new JdbcDao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddCatAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(!Name.getText().equals("")&!Code.getText().equals("")){
         try{
        dao.InsertCat(Code.getText(), Name.getText(), Image.getText());
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
