/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class CustomersController implements Initializable {

    @FXML
    private TableView<OneCustomer> ListOfCustomers;
    @FXML
    private TableColumn<OneCustomer, String> Name;
    @FXML
    private TableColumn<OneCustomer, String> Phone;
    @FXML
    private TableColumn<OneCustomer, String> EmailAddress;
    JdbcDao dao=new JdbcDao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Name.setCellValueFactory(
                new PropertyValueFactory<OneCustomer, String>("name"));
        Phone.setCellValueFactory(
                new PropertyValueFactory<OneCustomer, String>("Phone"));
        EmailAddress.setCellValueFactory(
                new PropertyValueFactory<OneCustomer, String>("Email"));
        try {
            ResultSet resultSet = dao.GetCusteomer();
             while (resultSet.next()) {
                 OneCustomer  customer=new OneCustomer(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("phone"), resultSet.getString("email"));
                 ListOfCustomers.getItems().add(customer);
             }

        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void AddCustomer(ActionEvent event) {
           try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("AddCustomer.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }
    
}
