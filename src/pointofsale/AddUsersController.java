/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class AddUsersController implements Initializable {

    @FXML
    private TextField FirstName;
    @FXML
    private ComboBox<String> Group;
    @FXML
    private TextField LastName;
    @FXML
    private TextField Phone;
    @FXML
    private TextField Email;
    @FXML
    private TextField UserName;
    @FXML
    private ComboBox<String> Sex;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField Password1;
    @FXML
    private ComboBox<String> Status;
    JdbcDao dao = new JdbcDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Status.getItems().add("غير نشط");
        Status.getItems().add("نشط ");
        Sex.getItems().add("ذكر ");
        Sex.getItems().add(" انثى");
        Group.getItems().add("admin");
        Group.getItems().add("staff");
    }

    @FXML
    private void AddUsers(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (!FirstName.getText().equals("") & !LastName.getText().equals("") & !UserName.getText().equals("") & !Password.getText().equals("") & !Password1.getText().equals("") & !Status.getSelectionModel().getSelectedItem().equals("")) {
            try {
                if (!Password.getText().equals(Password1.getText())) {
                    alert.setContentText("كلمة السر غير متطابقة");
                    alert.show();
                } else {
                    dao.InsertUser(Group.getSelectionModel().getSelectedIndex() + 1, FirstName.getText(), LastName.getText(), Phone.getText(), Sex.getSelectionModel().getSelectedItem(), Email.getText(), UserName.getText(), Password.getText(), Status.getSelectionModel().getSelectedIndex());
                  Stage stage1 = (Stage) Group.getScene().getWindow();
                stage1.close();  
                }
            } catch (Exception e) {
                alert.setContentText("خطاء في المدخلات");
                alert.show();
                System.err.println(e);
            }

        } else {
            alert.setContentText("الرجاء ملء كل الحقول");
            alert.show();

        }
    }

}
