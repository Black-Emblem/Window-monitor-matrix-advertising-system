package com.example.windowmonitormatrix;

import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.util.StringConverter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.windowmonitormatrix.database.dbf.*;

public class MainController {

    @FXML
    private ListView listingsList;
    @FXML
    private ListView advertsList;

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


    @FXML
    private TextField TFadid;
    @FXML
    private TextField TFlistingadRelationID;
    @FXML
    private TextField TFpriority;
    @FXML
    private TextField TFscreentime;
    @FXML
    private TextField TFrow;
    @FXML
    private TextField TFcolumn;
    @FXML
    private TextField TFalterad;
    @FXML
    private TextField TFlistinginternalID;
    @FXML
    private TextField TFlistingID;
    @FXML
    private TextField TFlistingurl;
    @FXML
    private TextField TFlistingmviewurl;
    @FXML
    private TextField TFupdatelistingID;
    @FXML
    private TextField TFnewlistingID;

    @FXML
    private DatePicker DFstartdate;
    @FXML
    private DatePicker DFenddate;

    @FXML
    private CheckBox CB1;
    @FXML
    private CheckBox CB2;
    @FXML
    private CheckBox CB3;
    @FXML
    private CheckBox CB4;
    @FXML
    private CheckBox CB5;
    @FXML
    private CheckBox CB6;
    @FXML
    private CheckBox CB7;
    @FXML
    private CheckBox CB8;
    @FXML
    private CheckBox CB9;


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

        int temp = -1;

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

        temp=getNumberOfentrys("listing_relation")+1;
        for (int i = 1; i < temp; i++) {
            advertsList.getItems().add("Add ID: "+ i +" | Listing ID: "+getVarcharfromtable(i,"listing_relation","listing_relation_id","add_id")+" | View state: "+getVstateOfAd(i)+" | Priority: "+getIntfromtable(i,"listing_relation","priority","add_id")+" | Screentime: "+getIntfromtable(i,"listing_relation","screentime","add_id")+" | Row: "+getIntfromtable(i,"listing_relation","pref_position_row","add_id")+" Column: "+getIntfromtable(i,"listing_relation","pref_position_column","add_id"));
        }
        temp=-1;
        temp=getNumberOfentrys("listings")+1;
        for (int i = 1; i < temp; i++) {
            listingsList.getItems().add("Internal ID: "+ i +" | Listing ID: "+getStringfromtable(i,"listings","listing_uid","ID")+" | Normal URL: "+getStringfromtable(i,"listings","norm_site_url","ID")+" | Monitorview URL: "+getStringfromtable(i,"listings","mview_url","ID"));
        }

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
        if (MS2.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS2.setText("State: OFF");
            SB2.setText("Turn ON");
        } else {
            setMonitorState(1, 1);
            MS2.setText("State: ON");
            SB2.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB3A() throws SQLException {
        if (MS3.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS3.setText("State: OFF");
            SB3.setText("Turn ON");
        } else {
            setMonitorState(1, 1);
            MS3.setText("State: ON");
            SB3.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB4A() throws SQLException {
        if (MS4.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS4.setText("State: OFF");
            SB4.setText("Turn ON");
        } else {
            setMonitorState(1, 1);
            MS4.setText("State: ON");
            SB4.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB5A() throws SQLException {
        if (MS5.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS5.setText("State: OFF");
            SB5.setText("Turn ON");
        } else {
            setMonitorState(1, 1);
            MS5.setText("State: ON");
            SB5.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB6A() throws SQLException {
        if (MS6.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS6.setText("State: OFF");
            SB6.setText("Turn ON");
        } else {
            setMonitorState(1, 1);
            MS6.setText("State: ON");
            SB6.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB7A() throws SQLException {
        if (MS7.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS7.setText("State: OFF");
            SB7.setText("Turn ON");
        } else {
            setMonitorState(1, 1);
            MS7.setText("State: ON");
            SB7.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB8A() throws SQLException {
        if (MS8.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS8.setText("State: OFF");
            SB8.setText("Turn ON");
        } else {
            setMonitorState(1, 1);
            MS8.setText("State: ON");
            SB8.setText("Turn OFF");
        }
    }

    @FXML
    private void onSB9A() throws SQLException {
        if (MS9.getText() == "State: ON"){
            setMonitorState(1, 0);
            MS9.setText("State: OFF");
            SB9.setText("Turn ON");
        } else {
            setMonitorState(1, 1);
            MS9.setText("State: ON");
            SB9.setText("Turn OFF");
        }
    }


    @FXML
    private void onSelectAd(ActionEvent event) throws SQLException {
        int temp=getNumberOfentrys("listing_relation")+1;
        for (int i = 1; i < temp; i++) {
            if (advertsList.getSelectionModel().getSelectedItem().equals("Add ID: "+ i +" | Listing ID: "+getVarcharfromtable(i,"listing_relation","listing_relation_id","add_id")+" | View state: "+getVstateOfAd(i)+" | Priority: "+getIntfromtable(i,"listing_relation","priority","add_id")+" | Screentime: "+getIntfromtable(i,"listing_relation","screentime","add_id")+" | Row: "+getIntfromtable(i,"listing_relation","pref_position_row","add_id")+" Column: "+getIntfromtable(i,"listing_relation","pref_position_column","add_id"))){
                TFadid.setText(String.valueOf(i));
                TFlistingadRelationID.setText(getVarcharfromtable(i,"listing_relation","listing_relation_id","add_id"));
                TFpriority.setText(String.valueOf(getIntfromtable(i,"listing_relation","priority","add_id")));
                TFscreentime.setText(String.valueOf(getIntfromtable(i,"listing_relation","screentime","add_id")));
                int row=getIntfromtable(i,"listing_relation","pref_position_row","add_id");
                TFrow.setText(String.valueOf(row));
                int column=getIntfromtable(i,"listing_relation","pref_position_column","add_id");
                TFcolumn.setText(String.valueOf(column));
                StringConverter converter = new StringConverter<LocalDate>() {
                    DateTimeFormatter dateFormatter =
                            DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    @Override
                    public String toString(LocalDate date) {
                        if (date != null) {
                            return dateFormatter.format(date);
                        } else {
                            return "";
                        }
                    }
                    @Override
                    public LocalDate fromString(String string) {
                        if (string != null && !string.isEmpty()) {
                            return LocalDate.parse(string, dateFormatter);
                        } else {
                            return null;
                        }
                    }
                };
                DFstartdate.setConverter(converter);
                DFstartdate.setPromptText("yyyy-mm-dd");
                DFenddate.setConverter(converter);
                DFenddate.setPromptText("yyyy-mm-dd");
                DFstartdate.setValue(LocalDate.parse(getDatefromtable(i,"listing_relation","start_date","add_id")));
                DFenddate.setValue(LocalDate.parse(getDatefromtable(i,"listing_relation","end_date","add_id")));

                if(row<0 && column==0){
                    if (row==-1){
                        CB1.setIndeterminate(true);
                        CB2.setIndeterminate(true);
                        CB3.setIndeterminate(true);
                        CB4.setSelected(false);
                        CB5.setSelected(false);
                        CB6.setSelected(false);
                        CB7.setSelected(false);
                        CB8.setSelected(false);
                        CB9.setSelected(false);
                    } else if (row==-2) {
                        CB4.setIndeterminate(true);
                        CB5.setIndeterminate(true);
                        CB6.setIndeterminate(true);
                        CB1.setSelected(false);
                        CB2.setSelected(false);
                        CB3.setSelected(false);
                        CB7.setSelected(false);
                        CB8.setSelected(false);
                        CB9.setSelected(false);
                    }
                    else if (row==-3) {
                        CB7.setIndeterminate(true);
                        CB8.setIndeterminate(true);
                        CB9.setIndeterminate(true);
                        CB1.setSelected(false);
                        CB2.setSelected(false);
                        CB3.setSelected(false);
                        CB4.setSelected(false);
                        CB5.setSelected(false);
                        CB6.setSelected(false);
                    }
                } else if (row==0 && column<0) {
                    if (column==-1){
                        CB1.setIndeterminate(true);
                        CB4.setIndeterminate(true);
                        CB7.setIndeterminate(true);
                        CB2.setSelected(false);
                        CB5.setSelected(false);
                        CB8.setSelected(false);
                        CB3.setSelected(false);
                        CB6.setSelected(false);
                        CB9.setSelected(false);
                    } else if (column==-2){
                        CB2.setIndeterminate(true);
                        CB5.setIndeterminate(true);
                        CB8.setIndeterminate(true);
                        CB1.setSelected(false);
                        CB4.setSelected(false);
                        CB7.setSelected(false);
                        CB3.setSelected(false);
                        CB6.setSelected(false);
                        CB9.setSelected(false);
                    } else if (column==-3){
                        CB3.setIndeterminate(true);
                        CB6.setIndeterminate(true);
                        CB9.setIndeterminate(true);
                        CB1.setSelected(false);
                        CB4.setSelected(false);
                        CB7.setSelected(false);
                        CB2.setSelected(false);
                        CB5.setSelected(false);
                        CB8.setSelected(false);
                    }
                } else if (row>0 && column>0) {
                    switch (row){
                        case 1:
                            switch (column){
                                case 1:
                                    CB1.setSelected(true);
                                    CB2.setSelected(false);
                                    CB3.setSelected(false);
                                    CB4.setSelected(false);
                                    CB5.setSelected(false);
                                    CB6.setSelected(false);
                                    CB7.setSelected(false);
                                    CB8.setSelected(false);
                                    CB9.setSelected(false);
                                    break;
                                case 2:
                                    CB1.setSelected(false);
                                    CB2.setSelected(true);
                                    CB3.setSelected(false);
                                    CB4.setSelected(false);
                                    CB5.setSelected(false);
                                    CB6.setSelected(false);
                                    CB7.setSelected(false);
                                    CB8.setSelected(false);
                                    CB9.setSelected(false);
                                    break;
                                case 3:
                                    CB1.setSelected(false);
                                    CB2.setSelected(false);
                                    CB3.setSelected(true);
                                    CB4.setSelected(false);
                                    CB5.setSelected(false);
                                    CB6.setSelected(false);
                                    CB7.setSelected(false);
                                    CB8.setSelected(false);
                                    CB9.setSelected(false);
                                    break;
                            }
                            break;
                        case 2:
                            switch (column){
                                case 1:
                                    CB1.setSelected(false);
                                    CB2.setSelected(false);
                                    CB3.setSelected(false);
                                    CB4.setSelected(true);
                                    CB5.setSelected(false);
                                    CB6.setSelected(false);
                                    CB7.setSelected(false);
                                    CB8.setSelected(false);
                                    CB9.setSelected(false);
                                    break;
                                case 2:
                                    CB1.setSelected(false);
                                    CB2.setSelected(false);
                                    CB3.setSelected(false);
                                    CB4.setSelected(false);
                                    CB5.setSelected(true);
                                    CB6.setSelected(false);
                                    CB7.setSelected(false);
                                    CB8.setSelected(false);
                                    CB9.setSelected(false);
                                    break;
                                case 3:
                                    CB1.setSelected(false);
                                    CB2.setSelected(false);
                                    CB3.setSelected(false);
                                    CB4.setSelected(false);
                                    CB5.setSelected(false);
                                    CB6.setSelected(true);
                                    CB7.setSelected(false);
                                    CB8.setSelected(false);
                                    CB9.setSelected(false);
                                    break;
                            }
                            break;
                        case 3:
                            switch (column){
                                case 1:
                                    CB1.setSelected(false);
                                    CB2.setSelected(false);
                                    CB3.setSelected(false);
                                    CB4.setSelected(false);
                                    CB5.setSelected(false);
                                    CB6.setSelected(false);
                                    CB7.setSelected(true);
                                    CB8.setSelected(false);
                                    CB9.setSelected(false);
                                    break;
                                case 2:
                                    CB1.setSelected(false);
                                    CB2.setSelected(false);
                                    CB3.setSelected(false);
                                    CB4.setSelected(false);
                                    CB5.setSelected(false);
                                    CB6.setSelected(false);
                                    CB7.setSelected(false);
                                    CB8.setSelected(true);
                                    CB9.setSelected(false);
                                    break;
                                case 3:
                                    CB1.setSelected(false);
                                    CB2.setSelected(false);
                                    CB3.setSelected(false);
                                    CB4.setSelected(false);
                                    CB5.setSelected(false);
                                    CB6.setSelected(false);
                                    CB7.setSelected(false);
                                    CB8.setSelected(false);
                                    CB9.setSelected(true);
                                    break;
                            }
                            break;
                    }
                } else{
                    CB1.setSelected(false);
                    CB4.setSelected(false);
                    CB7.setSelected(false);
                    CB2.setSelected(false);
                    CB5.setSelected(false);
                    CB8.setSelected(false);
                    CB3.setSelected(false);
                    CB6.setSelected(false);
                    CB9.setSelected(false);
                }
            }
        }
    }

    @FXML
    private void onSelectListing() throws SQLException {
        int temp=getNumberOfentrys("listings")+1;
        for (int i = 1; i < temp; i++) {
            if (listingsList.getSelectionModel().getSelectedItem().equals("Internal ID: "+ i +" | Listing ID: "+getStringfromtable(i,"listings","listing_uid","ID")+" | Normal URL: "+getStringfromtable(i,"listings","norm_site_url","ID")+" | Monitorview URL: "+getStringfromtable(i,"listings","mview_url","ID"))){
                TFlistinginternalID.setText(String.valueOf(i));
                TFlistingID.setText(String.valueOf(getStringfromtable(i,"listings","listing_uid","ID")));
                TFlistingurl.setText(getStringfromtable(i,"listings","norm_site_url","ID"));
                TFlistingmviewurl.setText(getStringfromtable(i,"listings","mview_url","ID"));
            }
        }
    }

    @FXML
    private void onAlterAD(ActionEvent event) throws SQLException {

        if (alterListingRelation(Integer.parseInt(TFadid.getText()),TFlistingadRelationID.getText())){
            advertsList.getItems().clear();
            advertsList.getSelectionModel().clearSelection();
            int temp=getNumberOfentrys("listing_relation")+1;
            for (int i = 1; i < temp; i++) {
                advertsList.getItems().add("Add ID: "+ i +" | Listing ID: "+getVarcharfromtable(i,"listing_relation","listing_relation_id","add_id")+" | View state: "+getVstateOfAd(i)+" | Priority: "+getIntfromtable(i,"listing_relation","priority","add_id")+" | Screentime: "+getIntfromtable(i,"listing_relation","screentime","add_id")+" | Row: "+getIntfromtable(i,"listing_relation","pref_position_row","add_id")+" Column: "+getIntfromtable(i,"listing_relation","pref_position_column","add_id"));
            }

        }
    }

    @FXML
    private void onUpdatelisting(ActionEvent event) throws SQLException {
        //to be added
    }

    @FXML
    private void onRefreshAdList(ActionEvent event) throws SQLException {
        advertsList.getItems().clear();
        advertsList.getSelectionModel().clearSelection();
        int temp=getNumberOfentrys("listing_relation")+1;
        for (int i = 1; i < temp; i++) {
            advertsList.getItems().add("Add ID: "+ i +" | Listing ID: "+getVarcharfromtable(i,"listing_relation","listing_relation_id","add_id")+" | View state: "+getVstateOfAd(i)+" | Priority: "+getIntfromtable(i,"listing_relation","priority","add_id")+" | Screentime: "+getIntfromtable(i,"listing_relation","screentime","add_id")+" | Row: "+getIntfromtable(i,"listing_relation","pref_position_row","add_id")+" Column: "+getIntfromtable(i,"listing_relation","pref_position_column","add_id"));
        }
    }

    @FXML
    private void onRefreshListingList(ActionEvent event) throws SQLException {
        listingsList.getItems().clear();
        listingsList.getSelectionModel().clearSelection();
        int temp=getNumberOfentrys("listings")+1;
        for (int i = 1; i < temp; i++) {
            listingsList.getItems().add("Internal ID: "+ i +" | Listing ID: "+getStringfromtable(i,"listings","listing_uid","ID")+" | Normal URL: "+getStringfromtable(i,"listings","norm_site_url","ID")+" | Monitorview URL: "+getStringfromtable(i,"listings","mview_url","ID"));
        }
    }

    @FXML
    private void onCreatenewlisting(ActionEvent event) throws SQLException {
        int temp = Integer.parseInt(TFnewlistingID.getText());
        if (newListing(String.valueOf(temp))){
            int i = Integer.parseInt(getStringfromtable(temp,"listings","ID","listing_uid"));
            listingsList.getItems().add("Internal ID: "+ i +" | Listing ID: "+temp+" | Normal URL: "+getStringfromtable(i,"listings","norm_site_url","ID")+" | Monitorview URL: "+getStringfromtable(i,"listings","mview_url","ID"));
            TFnewlistingID.setText("");
        }
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