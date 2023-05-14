package com.example.seguimiento14;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;


import java.net.URL;
import java.util.ResourceBundle;

public class AgregaController implements Initializable {
    @FXML
    private Button agregarBtn;

    @FXML
    private TextField descripcionTf;

    @FXML
    private DatePicker fechaDp;

    @FXML
    private TextField montoTf;

    @FXML
    private ComboBox<String> tipoCb;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoCb.setPromptText("Seleccione el tipo");
        ObservableList<String> items= FXCollections.observableArrayList("Ingreso" , "Gasto");
        tipoCb.setItems(items);
        agregarBtn.setOnAction(Action-> {
            String descripcion= descripcionTf.getText();
            Tipo tipo;
            if (tipoCb.getSelectionModel().isSelected(0)){
                tipo= Tipo.INGRESO;
            }else {
                tipo= Tipo.GASTO;
            }
            double monto= Double.parseDouble(montoTf.getText());

            LocalDate fechaSeleccionada = fechaDp.getValue();
            Instant instant = Instant.from(fechaSeleccionada.atStartOfDay(ZoneId.systemDefault()));
            Date fecha = Date.from(instant);
            Dato dato= new Dato(descripcion , monto, tipo , fecha);
            DatosList.getInstance().getDatos().add(dato);
            Stage stage= (Stage) agregarBtn.getScene().getWindow();
            stage.close();
            HelloApplication.openWindow("hello-view.fxml");
        });
    }
}
