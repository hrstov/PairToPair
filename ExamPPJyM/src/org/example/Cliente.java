package org.example;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String dni;
    private String nTarjeta;

    private String matriculacochealquilado;
    private Vehiculo vAlquilado;

    public Cliente(String nombre, String apellidos, String email, String telefono, String dni, String nTarjeta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.nTarjeta = nTarjeta;
        this.matriculacochealquilado = "";
        this.vAlquilado = null;
    }


    public String getMatriculacochealquilado() {
        return matriculacochealquilado;
    }

    public void setMatriculacochealquilado(String matriculacochealquilado) {
        this.matriculacochealquilado = matriculacochealquilado;
    }


    public Vehiculo getvAlquilado() {
        return vAlquilado;
    }

    public void setvAlquilado(Vehiculo vAlquilado) {
        this.vAlquilado = vAlquilado;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getnTarjeta() {
        return nTarjeta;
    }

    public void setnTarjeta(String nTarjeta) {
        this.nTarjeta = nTarjeta;
    }


}
