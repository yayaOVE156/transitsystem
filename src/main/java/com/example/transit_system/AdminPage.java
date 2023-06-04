package com.example.transit_system;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class AdminPage extends Application {
    @FXML
    Label welctitle;
    @FXML
    GridPane feedbackpane;
    @FXML
    ListView<Feedback> feedbacklist;



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
        feedbackpane.setVisible(false);

    }
    UserS userdata =UserS.getInstance();
    public void removea(ActionEvent e)throws IOException {
        welctitle.setVisible(false);
        adminpane.setVisible(true);
        feedbackpane.setVisible(false);


    }

    public void adda(ActionEvent e) throws IOException, ExecutionException, InterruptedException {
        if(userdata.getUsername().equals(usernameA.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("USERNAME IS CURRENT USER");
            alert.setContentText("CURRENT USER ERROR");

            alert.showAndWait();
        }else{
            String x;
            x=usernameA.getText();
            DatabaseHandler.setAdmin(x);
        }



    }

    public void rema(ActionEvent e) throws IOException, ExecutionException, InterruptedException {
        if(userdata.getUsername().equals(usernameA.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("USERNAME IS CURRENT USER");
            alert.setContentText("CURRENT USER ERROR");

            alert.showAndWait();
        }else{
            String x;
            x=usernameA.getText();
            DatabaseHandler.setUser(x);
        }

    }
    public void showfeedback(ActionEvent e) throws IOException, ExecutionException, InterruptedException {
        welctitle.setVisible(false);
        adminpane.setVisible(false);
        feedbackpane.setVisible(true);

        List<Feedback> feedbacks = DatabaseHandler.getFeedbacks();
        ObservableList<Feedback> feedback = FXCollections.observableArrayList(); // Initialize the ObservableList

        feedback.addAll(feedbacks); // Add all the feedbacks to the ObservableList

        feedbacklist.setItems(feedback); // Set the ObservableList as the items for the ListView
        feedbacklist.refresh();

//        List<Feedback> feedbacks = DatabaseHandler.getFeedbacks();
//        ObservableList<Feedback> feedback = FXCollections.observableArrayList(); // Initialize the ObservableList
//
//        if (!feedbacks.isEmpty()) {
//            feedback.add(feedbacks.get(0)); // Add the first feedback from the feedbacks list to the ObservableList
//        }
//
//        feedbacklist.setItems(feedback); // Set the ObservableList as the items for the ListView
//        feedbacklist.refresh();

    }
    public void feedbacknext(ActionEvent e) throws IOException, ExecutionException, InterruptedException {
        ++iterator;
//        List<Feedback> feedbacks=DatabaseHandler.getFeedbacks();
//        feedbacklist.setItems((ObservableList<Feedback>) feedback.get(iterator));
    }

    public void feedbackprev(ActionEvent e) throws IOException, ExecutionException, InterruptedException {
        if(iterator>=0){
            --iterator;
        }
//        List<Feedback> feedbacks=DatabaseHandler.getFeedbacks();
//        feedbacklist.setItems((ObservableList<Feedback>) feedbacks.get(iterator));
    }

int iterator =0;
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