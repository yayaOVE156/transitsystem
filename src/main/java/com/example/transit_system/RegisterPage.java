package com.example.transit_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterPage extends Application {

   @FXML
    TextField psswrd;
   @FXML
   TextField psswrdR;
   @FXML
    Button registerbutton;

   @FXML
   Label Repeat;


    @Override

    @FXML
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegisterPage.class.getResource("Register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.show();
    }

    public void registerClick(ActionEvent e)throws IOException {
        if (!psswrd.getText().equals(psswrdR.getText())) {
            Repeat.setVisible(true);
        }




    }
    @FXML
    public void LoginPage(ActionEvent e) {
        Scene currentScene = ((Node) e.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();

        currentStage.close();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");

            loginStage.setScene(new Scene(root));
            loginStage.show();
        } catch (IOException f) {
            f.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch();
    }


}