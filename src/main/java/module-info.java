module com.example.windowmonitormatrix {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.web;


    opens com.example.windowmonitormatrix to javafx.fxml;
    exports com.example.windowmonitormatrix;
}