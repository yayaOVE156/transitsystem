package com.example.transit_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class HomePage extends Application {


    //Object instances related to the scenebuilder
    @FXML
    Label Welcometext;

    @FXML
    Button p1;
    @FXML
    Button p2;
    @FXML
    Button p3;
    @FXML
    Button tr1;
    @FXML
    Button tr2;
    @FXML
    Button tr3;

    @FXML
    Label title47agz;
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
    TextArea feedbacktext;
    @FXML
    GridPane bus;

    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    CheckBox p1check;
    @FXML
    CheckBox p2check;
    @FXML
    CheckBox p3check;
    @FXML
    CheckBox b1check;
    @FXML
    CheckBox b2check;
    @FXML
    CheckBox b3check;

    @FXML
    CheckBox tr1check;
    @FXML
    CheckBox tr2check;
    @FXML
    CheckBox tr3check;


    @FXML
    TextField Tfrom;
    @FXML
    Button tax;
    @FXML
    GridPane booked;
    @FXML
    TextField Ttime;

    @FXML
    Label txitext;

    @FXML
    GridPane taxi;
    @FXML
    GridPane train;
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
        train.setVisible(false);
        taxi.setVisible(false);
        booked.setVisible(false);
        title47agz.setVisible(false);

    }
      
      @FXML
    public void feedbackshow(ActionEvent e)throws IOException{
        Welcometext.setVisible(false);
        feedbackpane.setVisible(true);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(false);
        bus.setVisible(false);
        train.setVisible(false);
        taxi.setVisible(false);
          booked.setVisible(false);
          title47agz.setVisible(false);
    }

    @FXML
    public void planeshow(ActionEvent e)throws IOException {
        Welcometext.setVisible(false);
        feedbackpane.setVisible(false);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(true);
        bus.setVisible(false);
        booked.setVisible(false);
        title47agz.setText("E7gz Plane");
        title47agz.setVisible(true);

    }
    @FXML
    public void busshow(ActionEvent e)throws IOException {
        Welcometext.setVisible(false);
        feedbackpane.setVisible(false);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(false);
        bus.setVisible(true);
        booked.setVisible(false);
        title47agz.setText("E7gz Bus");
        title47agz.setVisible(true);
    }

    public void taxishow(ActionEvent e)throws IOException {
        Welcometext.setVisible(false);
        feedbackpane.setVisible(false);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(false);
        bus.setVisible(false);
        taxi.setVisible(true);
        train.setVisible(false);
        booked.setVisible(false);
        title47agz.setText("E7gz Taxi");
        title47agz.setVisible(true);


    }

    public void trainshow(ActionEvent e)throws IOException {
        Welcometext.setVisible(false);
        feedbackpane.setVisible(false);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(false);
        bus.setVisible(false);
        taxi.setVisible(false);
        train.setVisible(true);
        title47agz.setText("E7gz Train");
        title47agz.setVisible(true);
        booked.setVisible(false);



    }

    public void logout(ActionEvent e)throws IOException{
        userdata.setUsername(null);
        Scene currentScene = ((Node) e.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();

        currentStage.close();

        Parent root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));

        LoginPage login = new LoginPage();
        login.start(new Stage());

    }

        //Planes
    public void eplane1(ActionEvent e)throws IOException{
        p1.setVisible(false);
        p1check.setSelected(true);
    }

    public void eplane2(ActionEvent e)throws IOException{
        p2.setVisible(false);
        p2check.setSelected(true);
    }
    public void eplane3(ActionEvent e)throws IOException{
        p3.setVisible(false);
        p3check.setSelected(true);
    }

    public void eplane1u(ActionEvent e)throws IOException{
        p1.setVisible(true);
        p1check.setSelected(false);
    }

    public void eplane2u(ActionEvent e)throws IOException{
        p2.setVisible(true);
        p2check.setSelected(false);
    }

    public void eplane3u(ActionEvent e)throws IOException{
        p3.setVisible(true);
        p3check.setSelected(false);
    }

    //bus
    public void ebus1(ActionEvent e)throws IOException{
        b1.setVisible(false);
        b1check.setSelected(true);
    }
    public void ebus2(ActionEvent e)throws IOException{
        b2.setVisible(false);
        b2check.setSelected(true);
    }
    public void ebus3(ActionEvent e)throws IOException{
        b3.setVisible(false);
        b3check.setSelected(true);
    }
    public void ebus1u(ActionEvent e)throws IOException{
        b1.setVisible(true);
        b1check.setSelected(false);
    }
    public void ebus2u(ActionEvent e)throws IOException{
        b2.setVisible(true);
        b2check.setSelected(false);
    }
    public void ebus3u(ActionEvent e)throws IOException{
        b3.setVisible(true);
        b3check.setSelected(false);
    }

    //taxi
    public void etaxi(ActionEvent e)throws IOException{
        tax.setVisible(false);
        txitext.setText("Location to Meet: " +Tfrom.getText()+ " Time: "+Ttime.getText()) ;

    }
    public void etaxiu(ActionEvent e)throws IOException{
        tax.setVisible(true);
        txitext.setText("Msh M7goz");

    }
    //train
    public void etrain1(ActionEvent e)throws IOException{
        tr1.setVisible(false);
        tr1check.setSelected(true);
    }
    public void etrain2(ActionEvent e)throws IOException{
        tr2.setVisible(false);
        tr2check.setSelected(true);
    }
    public void etrain3(ActionEvent e)throws IOException{
        tr3.setVisible(false);
        tr3check.setSelected(true);
    }

    public void etrain1u(ActionEvent e)throws IOException{
        tr1.setVisible(true);
        tr1check.setSelected(false);
    }
    public void etrain2u(ActionEvent e)throws IOException{
        tr2.setVisible(true);
        tr2check.setSelected(false);
    }

    public void etrain3u(ActionEvent e)throws IOException{
        tr3.setVisible(true);
        tr3check.setSelected(false);
    }

    public void bookshow(ActionEvent e)throws IOException{
        Welcometext.setVisible(false);
        feedbackpane.setVisible(false);
        fwzyAD.setVisible(false);
        ad1.setVisible(false);
        planes.setVisible(false);
        bus.setVisible(false);
        train.setVisible(false);
        taxi.setVisible(false);
        booked.setVisible(true);
        title47agz.setVisible(false);
    }

    public void feedbacksend(ActionEvent e) throws IOException, ExecutionException, InterruptedException {

        Random r =new Random();
        int x = r.nextInt(10000-1000)+1000;
        DatabaseHandler.addFeedBack(new Feedback(x,userdata.getUsername(),feedbacktext.getText(),new Date()));
    }




}
