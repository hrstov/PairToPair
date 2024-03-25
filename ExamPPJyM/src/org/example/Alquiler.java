package org.example;

import java.util.Calendar;

public class Alquiler {

    private Cliente cliente;
    private Vehiculo vehiculo;
    //private int dias;LIBRERIA CALENDAR
    private Calendar fecha;
    private int kms;


    public Alquiler(Cliente cliente, Vehiculo vehiculo, Calendar fecha, int kms) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.kms = kms;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }
}
