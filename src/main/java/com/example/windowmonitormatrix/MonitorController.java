package com.example.windowmonitormatrix;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class MonitorController {

    @FXML
    private WebView myWebView;

    @FXML
    public void initialize() {
        WebEngine webEngine = myWebView.getEngine();
        webEngine.load("http://www.example.com");
    }
}