package com.example.windowmonitormatrix;

import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.SQLException;

import static com.example.windowmonitormatrix.database.dbf.*;

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

    @FXML
    private Text MS1;
    @FXML
    private Text MS2;
    @FXML
    private Text MS3;
    @FXML
    private Text MS4;
    @FXML
    private Text MS5;
    @FXML
    private Text MS6;
    @FXML
    private Text MS7;
    @FXML
    private Text MS8;
    @FXML
    private Text MS9;

    @FXML
    private Button SB1;
    @FXML
    private Button SB2;
    @FXML
    private Button SB3;
    @FXML
    private Button SB4;
    @FXML
    private Button SB5;
    @FXML
    private Button SB6;
    @FXML
    private Button SB7;
    @FXML
    private Button SB8;
    @FXML
    private Button SB9;

    @FXML
    private Text MSL_ID_1;
    @FXML
    private Text MSL_ID_2;
    @FXML
    private Text MSL_ID_3;
    @FXML
    private Text MSL_ID_4;
    @FXML
    private Text MSL_ID_5;
    @FXML
    private Text MSL_ID_6;
    @FXML
    private Text MSL_ID_7;
    @FXML
    private Text MSL_ID_8;
    @FXML
    private Text MSL_ID_9;

    @FXML
    private Text MHB1;
    @FXML
    private Text MHB2;
    @FXML
    private Text MHB3;
    @FXML
    private Text MHB4;
    @FXML
    private Text MHB5;
    @FXML
    private Text MHB6;
    @FXML
    private Text MHB7;
    @FXML
    private Text MHB8;
    @FXML
    private Text MHB9;

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

        MS1.setText(getMonitorState(1) ? "State: ON" : "State: OFF");
        MS2.setText(getMonitorState(2) ? "State: ON" : "State: OFF");
        MS3.setText(getMonitorState(3) ? "State: ON" : "State: OFF");
        MS4.setText(getMonitorState(4) ? "State: ON" : "State: OFF");
        MS5.setText(getMonitorState(5) ? "State: ON" : "State: OFF");
        MS6.setText(getMonitorState(6) ? "State: ON" : "State: OFF");
        MS7.setText(getMonitorState(7) ? "State: ON" : "State: OFF");
        MS8.setText(getMonitorState(8) ? "State: ON" : "State: OFF");
        MS9.setText(getMonitorState(9) ? "State: ON" : "State: OFF");
        SB1.setText(getMonitorState(1) ? "Turn OFF" : "Turn ON");
        SB2.setText(getMonitorState(2) ? "Turn OFF" : "Turn ON");
        SB3.setText(getMonitorState(3) ? "Turn OFF" : "Turn ON");
        SB4.setText(getMonitorState(4) ? "Turn OFF" : "Turn ON");
        SB5.setText(getMonitorState(5) ? "Turn OFF" : "Turn ON");
        SB6.setText(getMonitorState(6) ? "Turn OFF" : "Turn ON");
        SB7.setText(getMonitorState(7) ? "Turn OFF" : "Turn ON");
        SB8.setText(getMonitorState(8) ? "Turn OFF" : "Turn ON");
        SB9.setText(getMonitorState(9) ? "Turn OFF" : "Turn ON");

        MSL_ID_1.setText(getMonitorView(1));
        MSL_ID_2.setText(getMonitorView(2));
        MSL_ID_3.setText(getMonitorView(3));
        MSL_ID_4.setText(getMonitorView(4));
        MSL_ID_5.setText(getMonitorView(5));
        MSL_ID_6.setText(getMonitorView(6));
        MSL_ID_7.setText(getMonitorView(7));
        MSL_ID_8.setText(getMonitorView(8));
        MSL_ID_9.setText(getMonitorView(9));

        MHB1.setText(getMonitorheartbeat(1));
        MHB2.setText(getMonitorheartbeat(2));
        MHB3.setText(getMonitorheartbeat(3));
        MHB4.setText(getMonitorheartbeat(4));
        MHB5.setText(getMonitorheartbeat(5));
        MHB6.setText(getMonitorheartbeat(6));
        MHB7.setText(getMonitorheartbeat(7));
        MHB8.setText(getMonitorheartbeat(8));
        MHB9.setText(getMonitorheartbeat(9));
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
    private void onSB1A() throws SQLException {
        if (MS1.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS1.setText("State: OFF");
            SB1.setText("Turn ON");
        }
        else {
            setMonitorState(1, 1);
            MS1.setText("State: ON");
            SB1.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB2A() throws SQLException {
        if (MS2.getText() == "State: ON") {
            setMonitorState(2, 0);
            MS2.setText("State: OFF");
            SB2.setText("Turn ON");
        } else {
            setMonitorState(2, 1);
            MS2.setText("State: ON");
            SB2.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB3A() throws SQLException {
        if (MS3.getText() == "State: ON") {
            setMonitorState(3, 0);
            MS3.setText("State: OFF");
            SB3.setText("Turn ON");
        } else {
            setMonitorState(3, 1);
            MS3.setText("State: ON");
            SB3.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB4A() throws SQLException {
        if (MS4.getText() == "State: ON") {
            setMonitorState(4, 0);
            MS4.setText("State: OFF");
            SB4.setText("Turn ON");
        } else {
            setMonitorState(4, 1);
            MS4.setText("State: ON");
            SB4.setText("Turn OFF");SB4.setText("Turn ON");
        }
    }

    @FXML
    private void onSB5A() throws SQLException {
        if (MS5.getText() == "State: ON") {
            setMonitorState(5, 0);
            MS5.setText("State: OFF");
            SB5.setText("Turn ON");
        } else {
            setMonitorState(5, 1);
            MS5.setText("State: ON");
            SB5.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB6A() throws SQLException {
        if (MS6.getText() == "State: ON") {
            setMonitorState(6, 0);
            MS6.setText("State: OFF");
            SB6.setText("Turn ON");
        } else {
            setMonitorState(6, 1);
            MS6.setText("State: ON");
            SB6.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB7A() throws SQLException {
        if (MS7.getText() == "State: ON") {
            setMonitorState(7, 0);
            MS7.setText("State: OFF");
            SB7.setText("Turn ON");
        } else {
            setMonitorState(7, 1);
            MS7.setText("State: ON");
            SB7.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB8A() throws SQLException {
        if (MS8.getText() == "State: ON") {
            setMonitorState(8, 0);
            MS8.setText("State: OFF");
            SB8.setText("Turn ON");
        } else {
            setMonitorState(8, 1);
            MS8.setText("State: ON");
            SB8.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB9A() throws SQLException {
        if (MS9.getText() == "State: ON") {
            setMonitorState(9, 0);
            MS9.setText("State: OFF");
            SB9.setText("Turn ON");
        } else {
            setMonitorState(9, 1);
            MS9.setText("State: ON");
            SB9.setText("Turn OFF");
        }
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

}