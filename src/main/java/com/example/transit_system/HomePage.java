package com.example.transit_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePage extends Application {


    //Object instances related to the scenebuilder
    @FXML
    Label Welcometext;
    @FXML
    ImageView fwzyAD;
    @FXML
    GridPane feedbackpane;
    @FXML
    Label ad1;
    @FXML
    Button feedback;
    @FXML
    Button home;
    @FXML
    GridPane planes;
    @FXML
    GridPane bus;

    @FXML
    MenuItem buss;

    @FXML
    MenuItem planess;
    @FXML
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("Home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Homepage");
        stage.setScene(scene);
        stage.show();

    }

    UserS userdata =UserS.getInstance();

    public  void welcometext(MouseEvent e)throws IOException,IllegalArgumentException{
        Welcometext.setText("Welcome " + userdata.getUsername());
    }
    public static void main(String[] args) {
        launch();
    }

    //When the feedback button is pressed
    @FXML
    public void homeshow(ActionEvent e)throws IOException {
        Welcometext.setVisible(true);
        feedbackpane.setVisible(false);
        fwzyAD.setVisible(true);
        ad1.setVisible(true);
        planes.setVisible(false);
        bus.setVisible(false);

    }
      
      @FXML
    public void feedbackshow(ActionEvent e)throws IOException{
        Welcometext.setVisible(false);
        feedbackpane.setVisible(true);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(false);
        bus.setVisible(false);
    }

    @FXML
    public void planeshow(ActionEvent e)throws IOException {
        Welcometext.setVisible(false);
        feedbackpane.setVisible(false);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(true);
        bus.setVisible(false);


    }
    @FXML
    public void busshow(ActionEvent e)throws IOException {
        Welcometext.setVisible(false);
        feedbackpane.setVisible(false);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(false);
        bus.setVisible(true);
    }

}
