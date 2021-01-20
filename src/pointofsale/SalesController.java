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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class SalesController implements Initializable {

    @FXML
    private TableView<OneSale> ListSales;
    @FXML
    private TableColumn<OneSale, String> Date;
    @FXML
    private TableColumn<OneSale, String> Customer;
    @FXML
    private TableColumn<OneSale, String> Total;
    @FXML
    private TableColumn<OneSale, String> Paid;
    @FXML
    private TableColumn<OneSale, String> Status;
    @FXML
    private TableColumn<OneSale, String> Actions;
    JdbcDao dao = new JdbcDao();
    ObservableList<OneSale> list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = FXCollections.observableArrayList();
        Date.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Date"));
        Customer.setCellValueFactory(new PropertyValueFactory<OneSale, String>("NameCustomer"));
        Total.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Total"));
        Paid.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Paid"));
        Status.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Status"));
         Actions.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Action"));
          
        try {
            // TODO
            ResultSet res = dao.GetSales();
            int i=0;
            while (res.next()) {
                list.add(new OneSale(
                        res.getString("id") + "",
                        res.getString("customer_name"),
                        res.getString("date"),
                        res.getString("total"),
                        res.getString("paid"),
                        res.getString("status")+""
                ));
                 ListSales.getItems().add(new OneSale(
                        res.getString("id") + "",
                        res.getString("customer_name"),
                        res.getString("date"),
                        res.getString("total"),
                        res.getString("paid"),
                        res.getString("status")+""
                ));
               Status.setCellFactory(column -> {
             return new TableCell<OneSale, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : getItem().toString());
                setGraphic(null);
                TableRow <OneSale> currentRow = getTableRow();
                if (!isEmpty()) {
                    if(!item.equals("Paid")) 
                        currentRow.setStyle("-fx-background-color:lightcoral");
                    else
                        currentRow.setStyle("-fx-background-color:lightgreen");
                }
            }
        };
    });
                }
             
        } catch (Exception ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
       
      
    }

}
