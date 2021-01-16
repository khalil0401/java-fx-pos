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
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private TextField barcodefiled;
    @FXML
    private TextField totalpayment;
    @FXML
    private ComboBox<String> customerLIst;
     HashMap <String,Integer> HashMapCustomer;

    public POSController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new JdbcDao();
        ObservableList<oneproduct> list = FXCollections.observableArrayList();
        ObservableList<oneproduct> lisProPaymentt = FXCollections.observableArrayList();
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
            ResultSet resultSet = dao.getproduct();
            while (resultSet.next()) {
                System.err.println(resultSet.getString("name"));
                oneproduct p = new oneproduct(
                        resultSet.getString("name"),
                        resultSet.getString("price"),
                        resultSet.getString("quantity"),
                        resultSet.getString("code"),
                        resultSet.getString("category_id"),
                        resultSet.getString("type"),
                        resultSet.getString("cost"),
                        "");
                // list.add(p);
                tableprod.getItems().add(p);

            }
            QuantityProPayment.setEditable(true);
            QuantityProPayment.setCellFactory(TextFieldTableCell.forTableColumn());
            tableprod.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                // lisProPaymentt.add(newValue);
                System.err.println(newValue.getName());
                listpayment.getItems().add(observable.getValue());
                float total = 0;
                for (int i = 0; i < listpayment.getItems().size(); i++) {
                    total = total + Float.valueOf(listpayment.getItems().get(i).getPrice());
                    totalpayment.setText(total + "");
                }
            });

            ResultSet resultSet1 = dao.GetCusteomer();
             HashMapCustomer =new HashMap<String ,Integer>();
            while (resultSet1.next()) {
                customerLIst.getItems().add(resultSet1.getString("name"));
                HashMapCustomer.put(resultSet1.getString("name"), resultSet1.getInt("id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(POSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //gridview=new GridPane();

    }

    @FXML
    private void BarCodeTyped(KeyEvent event) throws SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            ResultSet resultSet = dao.SearchProdByCodeAndName(barcodefiled.getText().toString());
            System.err.println(barcodefiled.getText().toString());
            while (resultSet.next()) {
                System.err.println(resultSet.getString("name"));
                oneproduct p = new oneproduct(resultSet.getString("name"),
                        resultSet.getString("price"),
                        resultSet.getString("quantity"),
                        resultSet.getString("code"),
                        resultSet.getString("category_id"),
                        resultSet.getString("type"),
                        resultSet.getString("cost"),
                        "");
                // list.add(p);
                for (int i = 0; i < tableprod.getItems().size(); i++) {
                    tableprod.getItems().clear();
                }
                tableprod.refresh();
                tableprod.getItems().add(p);

            }
        }
    }
    @FXML
    private void OnEditCommitQty(TableColumn.CellEditEvent<oneproduct, String> event) {
        ((oneproduct) event.getTableView().getItems().get(
                event.getTablePosition().getRow())).setQuantity(event.getNewValue());

    }

    @FXML
    private void PaymentAction(ActionEvent event) {
       try{    
        FXMLLoader fXLoader=new FXMLLoader(getClass().getResource("PaymentPopup.fxml"));
                Parent root= fXLoader.load();
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                PaidObject paidob=new PaidObject(listpayment.getItems().size()+"", totalpayment.getText());
                //stage.setUserData(paidob);
                PaymentPopupController controller=fXLoader.getController();
                controller.PassingData(paidob);
                stage.show();
        }catch(Exception e){
            
        }
    }

    @FXML
    private void PrintAction(ActionEvent event) {
    }

    @FXML
    private void HoldAction(ActionEvent event) {
    }

    @FXML
    private void CancelAction(ActionEvent event) {
    }

}
////
