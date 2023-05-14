package com.example.seguimiento14;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        openWindow("hello-view.fxml");
    }

    public static void openWindow(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml)); // FXML tiene una referencia al controller, por eso se activa
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}