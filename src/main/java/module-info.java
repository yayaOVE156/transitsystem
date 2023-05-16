module com.example.transit_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.transit_system to javafx.fxml;
    exports com.example.transit_system;
}