package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Empresa {

    private String nombreempresa;
    private Map<String, Cliente> mapaClientes;
    private List<Vehiculo> listaVehiculos;


    public Empresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
        this.mapaClientes = new HashMap<>();
        this.listaVehiculos = new ArrayList<>();
    }


    public boolean hayCliente(String id) {
        if (mapaClientes.containsKey(id)) {
            return true;
        }
        return false;
    }

    public boolean addCliente(String id, Cliente cliente) {
        if (cliente != null && !hayCliente(id)) {
            mapaClientes.put(id, cliente);
            return true;
        }
        return false;
    }

    public boolean hayVehiculo(String matricula) {
        for (Vehiculo v : listaVehiculos) {
            if (matricula.equalsIgnoreCase(v.getMatricula())) {
                return true;
            }
        }
        return false;
    }

    public boolean addVehiculo(Vehiculo vehiculo) {
        if (!hayVehiculo(vehiculo.getMatricula())) {
            listaVehiculos.add(vehiculo);
            return true;
        }
        return false;
    }

    public float cobro(Vehiculo vehiculo, String matricula, float km) {
        for (Vehiculo v : listaVehiculos) {
            if (matricula.equalsIgnoreCase(v.getMatricula())) {
                v.setKm(km);
                if (v.getKm() > 500) {
                    float precioMas = v.getPrecio() + (v.getPrecio() * 20 / 100);
                    return precioMas;
                } else {
                    return v.getPrecio();
                }
            }
        }
        return 0;
    }


    public String listaVehiculos(String tipo){
        StringBuilder listavehiculosString = new StringBuilder();
    /*getters de vehiculo genericos
    String matricula, String modelo, String marca, float km, float precio, String tipoMotor
    */
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo != null) {
                if (tipo.equalsIgnoreCase("coche") && vehiculo instanceof Coche) {
                    Coche coche = (Coche) vehiculo;
                    //int plazas, int puertas, float volumenM, String tipoM
                    listavehiculosString.append("Coche con matrícula: ").append(coche.getMatricula()).append(", Modelo: ")
                            .append(coche.getModelo()).append(", Marca: ").append(coche.getMarca()).append(", KMs: ")
                            .append(coche.getKm()).append(", Precio: ").append(coche.getPrecio()).append(", Tipo Motor: ")
                            .append(coche.getTipoMotor()).append(", Plazas: ").append(coche.getPlazas()).append(", Puertas: ")
                            .append(coche.getPuertas()).append(", Volumen: ").append(coche.getVolumenM()).append(", Tipo de coche: ")
                            .append(coche.getTipoM());

                } else if (tipo.equalsIgnoreCase("furgon") && vehiculo instanceof Furgon) {
                    Furgon furgon = (Furgon) vehiculo;


                } else if (tipo.equalsIgnoreCase("camion") && vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;


                }
            }
        }

        return listavehiculosString.toString();
    }

    public String getNombreempresa () {
        return nombreempresa;
    }

    public void setNombreempresa (String nombreempresa){
        this.nombreempresa = nombreempresa;
    }
}
