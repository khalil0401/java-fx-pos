/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import com.mysql.cj.protocol.Resultset;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class UsersController implements Initializable {

    @FXML
    private TableView<OneUser> ListUsers;
    @FXML
    private TableColumn<OneUser, String> FirstName;
    @FXML
    private TableColumn<OneUser, String> LastName;
    @FXML
    private TableColumn<OneUser, String> Email;
    @FXML
    private TableColumn<OneUser, String> Group;
    @FXML
    private TableColumn<OneUser, String> Status;
    @FXML
    private TableColumn<OneUser, String> Actions;
    JdbcDao dao = new JdbcDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FirstName.setCellValueFactory(new PropertyValueFactory("Firstname"));
        LastName.setCellValueFactory(new PropertyValueFactory("Lastname"));
        Email.setCellValueFactory(new PropertyValueFactory("Email"));
        Group.setCellValueFactory(new PropertyValueFactory("Group"));
        Status.setCellValueFactory(new PropertyValueFactory("Status"));
        Actions.setCellValueFactory(new PropertyValueFactory("Actions"));
        ResultSet res;
        try {
            res = dao.GetUsers();
            while (res.next()) {
                ListUsers.getItems().add(new OneUser(res.getString("id"), res.getString("username"), res.getString("email"), res.getString("first_name"), res.getString("last_name"), res.getString("active"), res.getString("group_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void AddUsersOnAction(ActionEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("AddUsers.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
