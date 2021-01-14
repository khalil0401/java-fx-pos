/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import com.sun.javafx.collections.ElementObservableListDecorator;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class POSController implements Initializable {

   
    @FXML
    private TableView<oneproduct> tableprod;
    private JdbcDao dao;
    @FXML
    private AnchorPane poslist;
    @FXML
    private TableColumn<oneproduct, String> name;
    @FXML
    private TableColumn<oneproduct, String> price;
    @FXML
    private TableColumn<oneproduct, String> Qantuty;
    @FXML
    private TableView<oneproduct> listpayment;
    @FXML
    private TableColumn<oneproduct, String> NameProPayment;
    @FXML
    private TableColumn<oneproduct, String> PriceProPayment;
    @FXML
    private TableColumn<oneproduct, String> QuantityProPayment;
    public POSController() {

     
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           dao=new JdbcDao();
           ObservableList<oneproduct> list=FXCollections.observableArrayList();
             ObservableList<oneproduct> lisProPaymentt=FXCollections.observableArrayList();
            name.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("name"));
             price.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Price"));
              Qantuty.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Quantity"));
               NameProPayment.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("name"));
             PriceProPayment.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Price"));
              QuantityProPayment.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Quantity"));
        try {
            ResultSet resultSet= dao.getproduct();
           while(resultSet.next()){
               System.err.println(resultSet.getString("name"));
               oneproduct p=new oneproduct(resultSet.getString("name"), resultSet.getString("price"), resultSet.getString("quantity"));
              // list.add(p);
               tableprod.getItems().add(p);
               
           }
           QuantityProPayment.setEditable(true);
           tableprod.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
              // lisProPaymentt.add(newValue);
               System.err.println(newValue.getName());
               listpayment.getItems().add(observable.getValue());
           } );
        } catch (SQLException ex) {
            Logger.getLogger(POSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //gridview=new GridPane();
      
       
    }

}
////
