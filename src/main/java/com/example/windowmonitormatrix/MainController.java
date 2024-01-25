package com.example.windowmonitormatrix;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Node root;
    @FXML
    private Button someButton;
    @FXML
    private ComboBox<String> someComboBox;
    @FXML
    private TextField someTextField;

    @FXML
    private void initialize() {
         // Initialization code
    }

    @FXML
    private void someButtonAction() {
         // Code for someButton action
    }

    @FXML
    private void someComboBoxAction() {
         // Code for someComboBox action
    }

    @FXML
    private void someTextFieldAction() {
         // Code for someTextField action
    }

    public void close() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}