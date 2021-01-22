/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;


import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class ReportsController implements Initializable {

    @FXML
    private TableView<OneSale> ListReportSale;
    @FXML
    private TableView<OneReportProduct> ListReportProduct;
    @FXML
    private TableColumn<OneSale, String> DateSale;
    @FXML
    private TableColumn<OneSale, String> CustomerSale;
    @FXML
    private TableColumn<OneSale, String> TotalSale;
    @FXML
    private TableColumn<OneSale, String> TaxSale;
    @FXML
    private TableColumn<OneSale, String> DiscountSale;
    @FXML
    private TableColumn<OneSale, String> GrandTotalSale;
    @FXML
    private TableColumn<OneSale, String> PaidSale;
    @FXML
    private TableColumn<OneSale, String> BalanceSale;
    @FXML
    private TableColumn<OneSale, String> StatusSale;
    @FXML
    private TableColumn<OneReportProduct, String> CodeProduct;
    @FXML
    private TableColumn<OneReportProduct, String> NameProduct;
    @FXML
    private TableColumn<OneReportProduct, String> SoldProduct;
    @FXML
    private TableColumn<OneReportProduct, String> TaxProduct;
    @FXML
    private TableColumn<OneReportProduct, String> CostProduct;
    @FXML
    private TableColumn<OneReportProduct, String> PaidProduct;
    @FXML
    private TableColumn<OneReportProduct, String> NetProfitProduct;
    JdbcDao dao=new JdbcDao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        DateSale.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Date"));
        CustomerSale.setCellValueFactory(new PropertyValueFactory<OneSale, String>("NameCustomer"));
        TotalSale.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Total"));
        // TaxSale.setCellValueFactory(new PropertyValueFactory<OneSale,String>(""));
        // DiscountSale.setCellValueFactory(new PropertyValueFactory<OneSale,String>(""));
        GrandTotalSale.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Total"));
        PaidSale.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Paid"));
        StatusSale.setCellValueFactory(new PropertyValueFactory<OneSale, String>("Status"));
        BalanceSale.setCellValueFactory(new PropertyValueFactory<OneSale, String>("BalanceSale"));
        /**
         * ************ **************                                    **
         */
        CodeProduct.setCellValueFactory(new PropertyValueFactory<OneReportProduct, String>("Code"));
        NameProduct.setCellValueFactory(new PropertyValueFactory<OneReportProduct, String>("Name"));
        SoldProduct.setCellValueFactory(new PropertyValueFactory<OneReportProduct, String>("NumberPieces"));
        // TaxProduct.setCellValueFactory(new PropertyValueFactory<OneReportProduct,String>("Date"));
        CostProduct.setCellValueFactory(new PropertyValueFactory<OneReportProduct, String>("Cost"));
        PaidProduct.setCellValueFactory(new PropertyValueFactory<OneReportProduct, String>("Price"));
        NetProfitProduct.setCellValueFactory(new PropertyValueFactory<OneReportProduct, String>("Profit"));
       try{
           ResultSet res =dao.GetSales();
            ResultSet res1 =dao.GetRaportProduct();
          while(res.next()){
             String Status;
             if(((Float.valueOf(res.getString("paid")))-Float.valueOf(res.getString("total")))<=0)
                 Status="جزئي";
             else
                 Status="مدفوع";
              ListReportSale.getItems().add(new OneSale(res.getString("id"),
                      res.getString("customer_name"),
                      res.getString("date"),
                      res.getString("total"), res.getString("paid"),
                      Status));
              
          }
          while(res1.next()){
              ListReportProduct.getItems().add(new OneReportProduct(res1.getString("product_id"),
                      res1.getString("product_name"),
                      res1.getString(5),
                      res1.getString(6),
                      res1.getString("product_code"), 
                      res1.getString(1),"",
                      res1.getString(4),""));
          }
       }catch(Exception e){
           System.err.println(e);
       }
    }

}
