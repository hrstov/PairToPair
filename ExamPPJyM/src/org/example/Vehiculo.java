package org.example;

public class Vehiculo {
    private String matricula;
    private String modelo;
    private String marca;
    private float km;
    private float precio;
    private String tipoMotor;

    public Vehiculo(String matricula, String modelo, String marca, float km, float precio, String tipoMotor) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.km = km;
        this.precio = precio;
        this.tipoMotor = tipoMotor;
    }



    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }
}
