module com.example.transit_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires firebase.admin;
    requires com.google.auth.oauth2;


    opens com.example.transit_system to javafx.fxml;
    exports com.example.transit_system;
}