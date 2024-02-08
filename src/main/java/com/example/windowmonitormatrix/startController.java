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
    private void connect(ActionEvent event) throws IOException {
        try {
            db_conn();
        } catch (SQLException e) {
            messageText.setText("We encounter a error while trying to connect to the database.");
            throw new RuntimeException(e);
        }

        if (startButton.getText()=="Enter"){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) startButton.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        }
        if (testConnection()=="Connection with database is successful."){
            messageText.setText("Connection with database is successful.");
            startButton.setText("Enter");
        }

    }
}