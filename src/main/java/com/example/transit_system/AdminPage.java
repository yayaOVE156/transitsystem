package com.example.transit_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class AdminPage extends Application {
    @FXML
    Label welctitle;

    @FXML
    TextField usernameA;

    @FXML
    GridPane adminpane;
    @FXML
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("Admin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


//    public void homeshow(ActionEvent e)throws IOException {
//
//
//
//    }
        public void addadmin(ActionEvent e)throws IOException {
        welctitle.setVisible(false);
        adminpane.setVisible(true);


    }

    public void removea(ActionEvent e)throws IOException {
        welctitle.setVisible(false);
        adminpane.setVisible(true);


    }

//    public void adda(ActionEvent e) throws IOException, ExecutionException, InterruptedException {
//        String x;
//        x=usernameA.getText();
//        //Adminstrator admin = new Adminstrator(DatabaseHandler.getUser(x));
//
//        DatabaseHandler.addAdmin(admin);
//
//
//    }
    public void logout(ActionEvent e)throws IOException{
        UserS userdata=UserS.getInstance();
        userdata.setUsername(null);
        Scene currentScene = ((Node) e.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();

        currentStage.close();

        Parent root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));

        LoginPage login = new LoginPage();
        login.start(new Stage());

    }


}