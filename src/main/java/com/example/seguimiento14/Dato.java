package com.example.seguimiento14;

import java.util.Date;

public class Dato {
    private String descripcion;
    private double monto;
    private Tipo tipo;

    private Date date;

    public Dato(String descripcion, double monto, Tipo tipo, Date date) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.tipo = tipo;
        this.date = date;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
