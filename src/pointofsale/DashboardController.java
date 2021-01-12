/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void posaction(MouseEvent event) {
        try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("POS.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
        }

    @FXML
    private void productsaction(MouseEvent event) {
         try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("Products.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }

    @FXML
    private void salesaction(MouseEvent event) {
         try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("Sales.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }

    @FXML
    private void cataction(MouseEvent event) {
         try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("Categories.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }

    @FXML
    private void customersaction(MouseEvent event) {
         try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("Customers.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }

    @FXML
    private void settingsaction(MouseEvent event) {
         try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("Settings.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }

    @FXML
    private void reportsaction(MouseEvent event) {
         try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("reports.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }

    @FXML
    private void usersaction(MouseEvent event) {
         try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("Users.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
    
        }catch(Exception e){
            
        }
    }

    @FXML
    private void backupaction(MouseEvent event) {
       
    }
    
}
