/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author benchek
 */
public class PointOfSale extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parentroot = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Loign");
        primaryStage.setResizable(false);
        primaryStage.setIconified(false);
        primaryStage.getIcons().add(new Image("file:src/pointofsale/icon/male.png"));

        primaryStage.setScene(new Scene(parentroot));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
