package com.example.windowmonitormatrix;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static com.example.windowmonitormatrix.database.dbconn.*;

public class startController {
    @FXML
    private Text messageText;

    @FXML
    private Button startButton;

    @FXML
    public void initialize() throws SQLException {
        db_conn();
    }

    @FXML
    private void connect(ActionEvent event) throws IOException {
        if (startButton.getText()=="Enter"){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("monitor demo.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) startButton.getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(root));
            stage.show();
        }
        if (testConnection()=="Connection with database is successful."){
            messageText.setText("Connection with database is successful.");
            startButton.setText("Enter");
        }

    }
}