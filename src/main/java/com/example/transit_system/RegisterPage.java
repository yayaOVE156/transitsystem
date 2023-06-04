package com.example.transit_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import java.util.Random;
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
import java.util.concurrent.ExecutionException;


public class RegisterPage extends Application {
    @FXML
    TextField psswrd;

    @FXML
    TextField psswrdR;
    @FXML
    Button registerbutton;
    @FXML
    Label Repeat;
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    TextField Username;
    @FXML
    TextField address;
    @FXML
    TextField phone;
    @FXML
    Label URepeat;
    @FXML
    Label miss;
    @FXML
    Label ERepeat;



    @Override

    @FXML
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegisterPage.class.getResource("Register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.show();
        // Username.setText("a");
//        TextField[] tf={psswrd,Username,phone,address,email};
//        for(int i=0;i<6;i++){
//            tf[i].setText("");
//        }
    }

    //Register button click
    public void registerClick(ActionEvent e) throws IOException, ExecutionException, InterruptedException {

        boolean passerror = false;

        boolean emailerror = false;

        boolean nameerror = false;

        if (!psswrd.getText().equals(psswrdR.getText())) {
            Repeat.setVisible(true);
            passerror = true;
        }else{
            Repeat.setVisible(false);
        }
        if(DatabaseHandler.getUser(Username.getText())!=null){
            URepeat.setVisible(true);
            nameerror = true;
        }else{
            URepeat.setVisible(false);
        }
        if(DatabaseHandler.checkEmail(email.getText())) {
            emailerror = true;
            ERepeat.setVisible(true);
        }
        else {
            ERepeat.setVisible(false);
        }

        if(psswrd.getText().isEmpty() || Username.getText().isEmpty() || email.getText().isEmpty()||address.getText().isEmpty()||name.getText().isEmpty()||phone.getText().isEmpty() || passerror || nameerror || emailerror){
            miss.setVisible(true);
        }else{
            Random ren =new Random();
            int ran =ren.nextInt(1000-100)+100;
            DatabaseHandler.addUser(new User(Username.getText(),psswrd.getText(),email.getText(),phone.getText(),address.getText(),ran));
        }

        //   addUser(new User("Yahya", "itsMe", "vipyahya50@gmail.com", "01003333455", "march", 50));
        //law get raga3t null


    }
    // When the login hyperlink is pressed
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