package com.example.windowmonitormatrix;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class startController {
    @FXML
    private Text messageText;

    @FXML
    private void connect(ActionEvent event) throws IOException {
        messageText.setText("Welcome to JavaFX Application!");
    }
}