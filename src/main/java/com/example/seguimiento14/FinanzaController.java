package com.example.seguimiento14;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FinanzaController implements Initializable {
    @FXML
    private Button combinadoBtn;

    @FXML
    private TableColumn<Dato, String> descripcionColumn;

    @FXML
    private Button eliminarBtn;

    @FXML
    private TableColumn<Dato, Date> fechaColumn;

    @FXML
    private Button gastosBtn;

    @FXML
    private Button ingresosBtn;

    @FXML
    private TableColumn<Dato, Double> montoColumn;

    @FXML
    private Button regresarBtn;

    @FXML
    private TableColumn<Dato, Tipo> tipoColumn;

    @FXML
    private TableView<Dato> datosTable;

    private ObservableList<Dato> gastos = FXCollections.observableArrayList();
    private ObservableList<Dato> ingresos= FXCollections.observableArrayList();
    private ObservableList<Dato> gatosYIngreso= FXCollections.observableArrayList();

    public void addGastosYIngresos(){
        for (int i=0; i < DatosList.getInstance().getDatos().size(); i++){
            gatosYIngreso.add(DatosList.getInstance().getDatos().get(i));
        }
    }

    public void addGastos(){
        for (int i=0; i < DatosList.getInstance().getDatos().size(); i++){
            if (DatosList.getInstance().getDatos().get(i).getTipo().equals(Tipo.GASTO)){
                gastos.add(DatosList.getInstance().getDatos().get(i));
            }
        }
    }

    public void addIngresos(){
        for (int i=0; i < DatosList.getInstance().getDatos().size(); i++){
            if (DatosList.getInstance().getDatos().get(i).getTipo().equals(Tipo.INGRESO)){
                ingresos.add(DatosList.getInstance().getDatos().get(i));
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        montoColumn.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        addGastosYIngresos();
        addGastos();
        addIngresos();

        ingresosBtn.setOnAction(Action->{
            datosTable.setItems(
                    ingresos
            );
        });

        gastosBtn.setOnAction(Action->{
            datosTable.setItems(
                    gastos
            );
        });

        combinadoBtn.setOnAction(Action->{
            datosTable.setItems(
                    gatosYIngreso
            );
        });

        regresarBtn.setOnAction(Action->{
            HelloApplication.openWindow("hello-view.fxml");
            Stage stage= (Stage) regresarBtn.getScene().getWindow();
            stage.close();
        });

        eliminarBtn.setOnAction(Action->{
            Dato dato= datosTable.getSelectionModel().getSelectedItem();
            if (dato != null){
                gatosYIngreso.remove(dato);
                gastos.remove(dato);
                ingresos.remove(dato);
                DatosList.getInstance().remove(dato);
            }
        });

    }
}
