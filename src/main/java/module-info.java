module com.example.windowmonitormatrix {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.windowmonitormatrix to javafx.fxml;
    exports com.example.windowmonitormatrix;
}