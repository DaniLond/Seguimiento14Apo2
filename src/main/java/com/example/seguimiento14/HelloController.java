package com.example.seguimiento14;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button ingresarBtn;

    @FXML
    private TextField balanceTf;

    @FXML
    private Button mostrarBtn;

    @FXML
    private Label balanceL;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ingresarBtn.setOnAction(action->{
            HelloApplication.openWindow("Agregar-View.fxml");
            Stage stage= (Stage) ingresarBtn.getScene().getWindow();
            stage.close();
        });

        mostrarBtn.setOnAction(action->{
            HelloApplication.openWindow("Finanza-View.fxml");
            Stage stage= (Stage) mostrarBtn.getScene().getWindow();
            stage.close();
        });

        double balance = DatosList.getInstance().calcularBalance();
        String balanceString = String.format("%.2f", balance);
        balanceL.setText(balanceString);
    }
}