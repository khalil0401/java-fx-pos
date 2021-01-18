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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private Button TotalButtion;
    @FXML
    private Text countpay;
    JdbcDao dao=new JdbcDao();
    PaidObject paidobject;
    @FXML
    private TextArea Comment;
    @FXML
    private TextField Notes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MethodPay.getItems().add("الدفع نقدا");
      
      
    }
    

    public void PassingData(PaidObject u) {
        this.paidobject=u;
        Totalpaid.setText(u.getTotal());
      
        TotalElement.setText(u.getTotalobject().size()+"");
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

    @FXML
    private void OnActionPay(ActionEvent event) throws SQLException {
       try{
           dao.InsertNewPayment(paidobject.getIdCustomer()
                , paidobject.getCustomerName()
                , Float.valueOf(Totalpay.getText())
                ,Integer.valueOf(TotalElement.getText())
                , Integer.valueOf(TotalElement.getText())
                ,Float.valueOf(Total.getText())
                , 1
                , Notes.getText()
                ,Comment.getText()
                , "Paid"
                ,paidobject.getTotalobject());
            Stage stage1 = (Stage) Total.getScene().getWindow();
                stage1.close();
       }catch(Exception e){
           System.err.println(e);
       }
    }
}
