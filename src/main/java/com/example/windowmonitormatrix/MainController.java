package com.example.windowmonitormatrix;

import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.sql.SQLException;

import static com.example.windowmonitormatrix.database.dbf.getMonitorView;

public class MainController {
    @FXML
    private WebView MV0;
    @FXML
    private WebView MV1;
    @FXML
    private WebView MV2;
    @FXML
    private WebView MV3;
    @FXML
    private WebView MV4;
    @FXML
    private WebView MV5;
    @FXML
    private WebView MV6;
    @FXML
    private WebView MV7;
    @FXML
    private WebView MV8;

    private WebEngine engine0;
    private WebEngine engine1;
    private WebEngine engine2;
    private WebEngine engine3;
    private WebEngine engine4;
    private WebEngine engine5;
    private WebEngine engine6;
    private WebEngine engine7;
    private WebEngine engine8;



    @FXML
    private Node root;
    @FXML
    private Button someButton;
    @FXML
    private ComboBox<String> someComboBox;
    @FXML
    private TextField someTextField;

    @FXML
    public void initialize() throws SQLException {

        engine0 = MV0.getEngine();
        engine1 = MV1.getEngine();
        engine2 = MV2.getEngine();
        engine3 = MV3.getEngine();
        engine4 = MV4.getEngine();
        engine5 = MV5.getEngine();
        engine6 = MV6.getEngine();
        engine7 = MV7.getEngine();
        engine8 = MV8.getEngine();

        engine0.setJavaScriptEnabled(true);
        engine1.setJavaScriptEnabled(true);
        engine2.setJavaScriptEnabled(true);
        engine3.setJavaScriptEnabled(true);
        engine4.setJavaScriptEnabled(true);
        engine5.setJavaScriptEnabled(true);
        engine6.setJavaScriptEnabled(true);
        engine7.setJavaScriptEnabled(true);
        engine8.setJavaScriptEnabled(true);

        engine0.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());
        engine1.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());
        engine2.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());
        engine3.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());
        engine4.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());
        engine5.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());
        engine6.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());
        engine7.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());
        engine8.setUserStyleSheetLocation(getClass().getResource("/hideScrollBar.css").toExternalForm());

        loadWebView(engine0, getMonitorView(1));
        loadWebView(engine1, getMonitorView(2));
        loadWebView(engine2, getMonitorView(3));
        loadWebView(engine3, getMonitorView(4));
        loadWebView(engine4, getMonitorView(5));
        loadWebView(engine5, getMonitorView(6));
        loadWebView(engine6, getMonitorView(7));
        loadWebView(engine7, getMonitorView(8));
        loadWebView(engine8, getMonitorView(9));
    }

    private void loadWebView(WebEngine engine, String propertyId) {
        engine.load("https://nowrealestate.gr/property/"+propertyId);
        engine.getLoadWorker().stateProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                System.out.println("Page has been loaded");
            } else if (newValue == Worker.State.FAILED) {
                System.out.println("Loading failed");
            }
        });
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
    public void onRefresh() throws SQLException {
        loadWebView(engine0, getMonitorView(1));
        loadWebView(engine1, getMonitorView(2));
        loadWebView(engine2, getMonitorView(3));
        loadWebView(engine3, getMonitorView(4));
        loadWebView(engine4, getMonitorView(5));
        loadWebView(engine5, getMonitorView(6));
        loadWebView(engine6, getMonitorView(7));
        loadWebView(engine7, getMonitorView(8));
        loadWebView(engine8, getMonitorView(9));
    }

    public void close() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}