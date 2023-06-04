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
import java.util.concurrent.ExecutionException;


public class LoginPage extends Application{

    @FXML
    Button Loginbutton;
    @FXML
    TextField username;
    @FXML
    TextField psswrd;
    @FXML
    Label Err;
    @FXML

        @Override
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
    public void loginClick(ActionEvent e) throws IOException, ExecutionException, InterruptedException {

        Object v = DatabaseHandler.getUser(username.getText());
        if(v instanceof Adminstrator){
            Adminstrator admin = (Adminstrator) v;
            if(!admin.getUserName().equals(username.getText()) || !admin.getPassword().equals(psswrd.getText())){
                Err.setVisible(true);
            }else{
                UserS userdata =UserS.getInstance();
                userdata.setUsername(username.getText());
                Scene currentScene = ((Node) e.getSource()).getScene();
                Stage currentStage = (Stage) currentScene.getWindow();

                currentStage.close();
                Parent root = FXMLLoader.load(getClass().getResource("Admin-view.fxml"));
//            Stage homeStage = new Stage();
//
//            homeStage.setTitle("Homepage");
//            homeStage.setScene(new Scene(root));
//            homeStage.show();
                AdminPage admino = new AdminPage();
                admino.start(new Stage());





            }

        }else{
            User user = (User)v;
            if(!user.getUserName().equals(username.getText()) || !user.getPassword().equals(psswrd.getText())){
                Err.setVisible(true);
            }else{
                UserS userdata =UserS.getInstance();
                userdata.setUsername(username.getText());
                Scene currentScene = ((Node) e.getSource()).getScene();
                Stage currentStage = (Stage) currentScene.getWindow();

                currentStage.close();
                Parent root = FXMLLoader.load(getClass().getResource("Home-view.fxml"));
//            Stage homeStage = new Stage();
//
//            homeStage.setTitle("Homepage");
//            homeStage.setScene(new Scene(root));
//            homeStage.show();
                HomePage home = new HomePage();
                home.start(new Stage());





            }
        }


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