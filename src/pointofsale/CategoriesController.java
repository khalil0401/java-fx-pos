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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class CategoriesController implements Initializable {

    @FXML
    private TableView<OneCategorie> ListofCat;
    @FXML
    private TableColumn<OneCategorie, String> Code;
    @FXML
    private TableColumn<OneCategorie, String> Name;
    @FXML
    private TableColumn<OneCategorie, String> Actions;
    JdbcDao dao=new JdbcDao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Name.setCellValueFactory(
                new PropertyValueFactory<OneCategorie, String>("Name"));
         Code.setCellValueFactory(
                new PropertyValueFactory<OneCategorie, String>("Code"));
         Actions.setCellValueFactory(
                new PropertyValueFactory<OneCategorie, String>("Actions"));   
         try {
            ResultSet resultSet = dao.GetCat();
            while (resultSet.next()) {
                System.err.println(resultSet.getString("name"));
                OneCategorie Cat = new OneCategorie(resultSet.getString("code"), resultSet.getString("name"),resultSet.getString("image"),"");
                // list.add(p);
                ListofCat.getItems().add(Cat);

            }
        }catch (Exception e){
            
        }
    }    

    @FXML
    private void Addcategories(ActionEvent event) {
           try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("AddCategories.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }
    
}
