package com.example.seguimiento14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class DatosList {
    private ArrayList<Dato> datos= new ArrayList<>();

    public ArrayList<Dato> getDatos() {
        Comparator<Dato> comparador = new Comparator<Dato>() {
            public int compare(Dato dato1, Dato dato2) {
                return dato2.getDate().compareTo(dato1.getDate());
            }
        };

        Collections.sort(datos, comparador);
        return datos;
    }

    public void setDatos(ArrayList<Dato> datos) {
        this.datos = datos;
    }

    public void remove(Dato dato){
        datos.remove(dato);
    }

    private DatosList(){

    }

    public static DatosList instance= null;

    public static DatosList getInstance(){
        if (instance== null){
            instance= new DatosList();
        }
        return instance;
    }

    public double calcularBalance(){
        double ingreso=0;
        double gastos=0;
        for (int i=0; i < datos.size(); i++){
            if (datos.get(i).getTipo().equals(Tipo.INGRESO)){
                ingreso += datos.get(i).getMonto();
            }
            if (datos.get(i).getTipo().equals(Tipo.GASTO)){
                gastos += datos.get(i).getMonto();
            }
        }
        return ingreso - gastos;
    }
}
