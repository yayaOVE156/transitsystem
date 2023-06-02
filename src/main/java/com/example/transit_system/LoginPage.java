package com.example.transit_system;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage extends Application {

    @FXML
    Button Loginbutton;
    @FXML
    TextField email;
    @FXML
    TextField psswrd;
    @FXML
    Label Err;
    @Override
    @FXML
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    public void RegisterClick(ActionEvent e) {
        Scene currentScene = ((Node) e.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();

        currentStage.close();

        try{
            Parent root = FXMLLoader.load(getClass().getResource("Register-view.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("Registration");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }catch (IOException f) {
            f.printStackTrace();
        }
    }
}