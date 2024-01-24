package com.example.windowmonitormatrix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowMonitorMatrix extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowMonitorMatrix.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 300);
        try {
            Image image = new Image("logo.png");
            if (image.isError()) {
                throw new RuntimeException(image.exceptionProperty().toString());
            }
            stage.getIcons().add(image);
        }
        catch(RuntimeException re)
        { System.out.println("Failed to load the Icon: " + re.getMessage()); }
        stage.setTitle("Window Monitor Matrix");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}