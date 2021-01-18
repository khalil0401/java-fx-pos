/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benchek
 */
public class DashboardController implements Initializable {

    @FXML
    private PieChart RapportPaidChart;
    @FXML
    private StackedBarChart<String, Double> StackPaidChart;
    @FXML
    private NumberAxis StackChartY;
    @FXML
    private CategoryAxis StackChartX;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RapportChart();
    }
    public void RapportChart(){
        ObservableList<PieChart.Data> array=FXCollections.observableArrayList(
                new PieChart.Data("Cars",13),new PieChart.Data("Cycles",13));
        RapportPaidChart.setData(array);
        XYChart.Series<String,Double> series =new XYChart.Series<>();
        series.setName("مبيعات");
         XYChart.Series<String,Double> series1 =new XYChart.Series<>();
        series1.setName("الخصم");
         XYChart.Series<String,Double> series2 =new XYChart.Series<>();
        series2.setName("الضرائب");
        series.getData().add(new XYChart.Data<>("jan", 300.0));
         series1.getData().add(new XYChart.Data<>("jan", 200.0));
          series2.getData().add(new XYChart.Data<>("jan", 20.0));
          StackPaidChart.getData().add(series);
          StackPaidChart.getData().add(series1);
          StackPaidChart.getData().add(series2);
    }
    @FXML
    private void posaction(MouseEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("POS.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    private void productsaction(MouseEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("Products.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    private void salesaction(MouseEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("Sales.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    private void cataction(MouseEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("Categories.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    private void customersaction(MouseEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("Customers.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    private void settingsaction(MouseEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    private void reportsaction(MouseEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("reports.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    private void usersaction(MouseEvent event) {
        try {
            FXMLLoader fXLoader = new FXMLLoader(getClass().getResource("Users.fxml"));
            Parent root = fXLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    private void backupaction(MouseEvent event) {

    }

}
