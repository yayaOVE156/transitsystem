package com.example.transit_system;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage extends Application {
    @Override

    @FXML
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 550);
        stage.setTitle("Hello!");
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
            registerStage.setScene(new Scene(root, 600, 550));
            registerStage.show();
        }catch (IOException f) {
            f.printStackTrace();
        }
    }
}