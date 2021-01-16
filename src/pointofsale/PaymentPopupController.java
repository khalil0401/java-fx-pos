/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class PaymentPopupController implements Initializable {

    @FXML
    private Text Totalpaid;
    @FXML
    private Text TotalElement;
    @FXML
    private Text Totalpay;
    @FXML
    private TextField Total;
    @FXML
    private ComboBox<String> MethodPay;
    @FXML
    private TextField comment;
    @FXML
    private Button TotalButtion;
    @FXML
    private Text countpay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MethodPay.getItems().add("الدفع نقدا");
    }

    public void PassingData(PaidObject u) {
        Totalpaid.setText(u.getTotal());
        TotalElement.setText(u.getTotalobject());
        Totalpay.setText(u.getTotal());
        Total.setText(u.getTotal());
        TotalButtion.setText(u.getTotal());
        

    }

    @FXML
    private void AddCountOnAction(ActionEvent event) {
       Button b=(Button) event.getSource();
       Totalpaid.setText((Float.valueOf(Totalpaid.getText().toString()))+(Float.valueOf(b.getText().toString()))+"");
       Total.setText((Float.valueOf(Total.getText().toString()))+(Float.valueOf(b.getText().toString()))+"");
       countpay.setText(""+((Float.valueOf(Totalpaid.getText()))-(Float.valueOf(Totalpay.getText()))));

    }

    @FXML
    private void clearOnAction(ActionEvent event) {
        Totalpaid.setText("0.00");
        Total.setText("0.00");
        countpay.setText("-"+Totalpay.getText());
    }
}
