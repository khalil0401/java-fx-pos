package pointofsale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class ProductsController implements Initializable {

    @FXML
    private TableView<oneproduct> ListOfProducts;
    @FXML
    private TableColumn<oneproduct, String> code;
    @FXML
    private TableColumn<oneproduct, String> Name;
    @FXML
    private TableColumn<oneproduct, String> Category;
    @FXML
    private TableColumn<oneproduct, String> Quantity;
    @FXML
    private TableColumn<oneproduct, String> Type;
    @FXML
    private TableColumn<oneproduct, String> Cost;
    @FXML
    private TableColumn<oneproduct, String> Price;
    @FXML
    private TableColumn<oneproduct, String> Actions;
     JdbcDao dao=new JdbcDao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Name.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("name"));
        Price.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Price"));
        Quantity.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Quantity"));
        code.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("code"));
        Category.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Category"));
        Type.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Type"));
         Cost.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Cost"));
          Actions.setCellValueFactory(
                new PropertyValueFactory<oneproduct, String>("Actions"));
        try {
            ResultSet resultSet = dao.getproduct();
            while (resultSet.next()) {
                System.err.println(resultSet.getString("name"));
                oneproduct p = new oneproduct(resultSet.getString("id"),
                        resultSet.getString("name"), 
                        resultSet.getString("price"),
                        resultSet.getString("quantity"),
                        resultSet.getString("code"),
                        resultSet.getString("category_id"),
                        resultSet.getString("type"),
                        resultSet.getString("cost"),
                        "");
                // list.add(p);
                ListOfProducts.getItems().add(p);

            }
        }catch (Exception e){
            
        }
    }    

    @FXML
    private void AddProducts(ActionEvent event) {
           try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("AddProducts.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }
    
}
