package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {

    private String nombreempresa;
    private Map<String, Cliente> mapaClientes;
    private List<Vehiculo> listaVehiculos;
    private List<Vehiculo> listaVEHAlquilados;


    public Empresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
        this.mapaClientes = new HashMap<>();
        this.listaVehiculos = new ArrayList<>();
        this.listaVEHAlquilados = new ArrayList<>();
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
    public boolean hayVehiculoAlquilado(String matricula) {
        for (Vehiculo v : listaVEHAlquilados) {
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


    public boolean alquilarVehiculo(String id, String matricula, String fechainicio/*no se usa de momento*/, int dia) {
        if (hayCliente(id)) {
            for (Vehiculo vehiculo : listaVehiculos) {
                if (matricula.equalsIgnoreCase(vehiculo.getMatricula())) {
                    listaVehiculos.remove(vehiculo);
                    listaVEHAlquilados.add(vehiculo);
                    for (Cliente cli : mapaClientes.values()) {
                        if (id.equalsIgnoreCase(cli.getDni())) {
                           // cli.setMatriculacochealquilado(matricula);
                            //set de matricula alquilado del cliente a matricula para asignar ese vehiculo

                            cli.setvAlquilado(vehiculo);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean returnVehiculo(String matricula/*, */) {
        for (Vehiculo veh : listaVehiculos) {
            if (veh != null && matricula.equalsIgnoreCase(veh.getMatricula())) {
               // listaVEHAlquilados.remove(veh);
               // listaVehiculos.add(veh);
                //set a null del v alquilado
                for (Cliente cli : mapaClientes.values()){
                    cli.setvAlquilado(null);

                }
                if (veh.getKm() > 500){

                }
            }

            //return true;
        }
        return false;
    }


    public String listaVehiculosGenerico(String tipo) {
        StringBuilder listavehiculosString = new StringBuilder();
    /*getters de vehiculo genericos
    String matricula, String modelo, String marca, float km, float precio, String tipoMotor
    */
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo != null) {
                if (tipo.equalsIgnoreCase("coche") && vehiculo instanceof Coche) {
                    Coche coche = (Coche) vehiculo;

                    //int plazas, int puertas, float volumenM, String tipoM
                    listavehiculosString.append("COCHE con matrícula: ").append(coche.getMatricula()).append(", Modelo: ")
                            .append(coche.getModelo()).append(", Marca: ").append(coche.getMarca()).append(", KMs: ")
                            .append(coche.getKm()).append(", Precio: ").append(coche.getPrecio()).append(", Tipo Motor: ")
                            .append(coche.getTipoMotor()).append(", Plazas: ").append(coche.getPlazas()).append(", Puertas: ")
                            .append(coche.getPuertas()).append(", Volumen: ").append(coche.getVolumenM()).append(", Tipo de coche: ")
                            .append(coche.getTipoM());

                } else if (tipo.equalsIgnoreCase("furgon") && vehiculo instanceof Furgon) {
                    Furgon furgon = (Furgon) vehiculo;
                    //float cargaMax, int plazas
                    listavehiculosString.append("FURGON con matrícula: ").append(furgon.getMatricula()).append(", Modelo: ")
                            .append(furgon.getModelo()).append(", Marca: ").append(furgon.getMarca()).append(", KMs: ")
                            .append(furgon.getKm()).append(", Precio: ").append(furgon.getPrecio()).append(", Tipo Motor: ")
                            .append(furgon.getTipoMotor()).append(", Carga máxima: ").append(furgon.getCargaMax()).append(", Plazas: ")
                            .append(furgon.getPlazas());

                } else if (tipo.equalsIgnoreCase("camion") && vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    //float cargaMax, float longi
                    listavehiculosString.append("CAMIÓN con matrícula: ").append(camion.getMatricula()).append(", Modelo: ")
                            .append(camion.getModelo()).append(", Marca: ").append(camion.getMarca()).append(", KMs: ")
                            .append(camion.getKm()).append(", Precio: ").append(camion.getPrecio()).append(", Tipo Motor: ")
                            .append(camion.getTipoMotor()).append(", Carga máxima: ").append(camion.getCargaMax()).append(", Longitud: ")
                            .append(camion.getLongi());
                }
            }
        }
        return listavehiculosString.toString();
    }

    public String listaCoches(String tipo, int plazas, String tipoMCoche) {
        StringBuilder listaCoches = new StringBuilder();
    /*getters de vehiculo genericos
    String matricula, String modelo, String marca, float km, float precio, String tipoMotor
    */
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo != null) {
                if (tipo.equalsIgnoreCase("coche") && vehiculo instanceof Coche) {
                    Coche coche = (Coche) vehiculo;
                    if (coche.getPlazas() >= plazas && tipoMCoche.equalsIgnoreCase(coche.getTipoMotor())) {
                        //int plazas, int puertas, float volumenM, String tipoM
                        listaCoches.append("COCHE con matrícula: ").append(coche.getMatricula()).append(", Modelo: ")
                                .append(coche.getModelo()).append(", Marca: ").append(coche.getMarca()).append(", KMs: ")
                                .append(coche.getKm()).append("Km, Precio: ").append(coche.getPrecio()).append(", Tipo Motor: ")
                                .append(coche.getTipoMotor()).append(", Plazas: ").append(coche.getPlazas()).append(", Puertas: ")
                                .append(coche.getPuertas()).append(", Volumen: ").append(coche.getVolumenM()).append(", Tipo de coche: ")
                                .append(coche.getTipoM()).append("\n");
                    }
                }
            }
        }
        return listaCoches.toString();
    }

    public String listaFurgon(String tipo, float cargamayor, int plazas) {
        StringBuilder listaFurgones = new StringBuilder();
        //String matricula, String modelo, String marca, float km, float precio, String tipoMotor
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo != null) {
                if (tipo.equalsIgnoreCase("furgon") && vehiculo instanceof Furgon) {
                    Furgon furgon = (Furgon) vehiculo;
                    if (furgon.getCargaMax() >= cargamayor && furgon.getPlazas() >= plazas) {
                        //float cargaMax, int plazas
                        listaFurgones.append("FURGON con matrícula: ").append(furgon.getMatricula()).append(", Modelo: ")
                                .append(furgon.getModelo()).append(", Marca: ").append(furgon.getMarca()).append(", KMs: ")
                                .append(furgon.getKm()).append("Km, Precio: ").append(furgon.getPrecio()).append(", Tipo Motor: ")
                                .append(furgon.getTipoMotor()).append(", Carga máxima: ").append(furgon.getCargaMax()).append(", Plazas: ")
                                .append(furgon.getPlazas()).append("\n");
                    }
                }
            }
        }
        return listaFurgones.toString();
    }

    public String listaCamion(String tipo, float cargamayor, float longitud) {
        StringBuilder listaCamiones = new StringBuilder();
        //String matricula, String modelo, String marca, float km, float precio, String tipoMotor
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo != null) {
                if (tipo.equalsIgnoreCase("camion") && vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    if (camion.getCargaMax() >= cargamayor && camion.getLongi() < longitud) {
                        //float cargaMax, float longi
                        listaCamiones.append("CAMIÓN con matrícula: ").append(camion.getMatricula()).append(", Modelo: ")
                                .append(camion.getModelo()).append(", Marca: ").append(camion.getMarca()).append(", KMs: ")
                                .append(camion.getKm()).append("Km, Precio: ").append(camion.getPrecio()).append(", Tipo Motor: ")
                                .append(camion.getTipoMotor()).append(", Carga máxima: ").append(camion.getCargaMax()).append(", Longitud: ")
                                .append(camion.getLongi()).append("\n");
                    }
                }
            }
        }
        return listaCamiones.toString();
    }


    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }
}
