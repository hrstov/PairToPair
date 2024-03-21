package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        String opcion;

        Empresa empresa = new Empresa("Sofenkro INC.");

        while(continuar) {
            System.out.println("""
                    1. Dar alta vehiculo
                    2. Dar alta cliente
                    3. Alquilar vehiculo determinado para un cliente determinado  
                    4. Mostrar lista de vehiculos
                    5. Cobrar
                    """);

            opcion = sc.nextLine();

            switch (opcion){
                case "0":
                    continuar = false;
                    break;

                case "1":

                    String sMat, sModelo, sMarca, sTipoMotor;
                    //tipos de motor: electrico, hibrido enchufable, hibrido, gasolina o diesel
                    float iKmsRecorr;
                    float flPrecioDia;
                    //orden String matricula, String modelo, String marca, float km, float precio, String tipoMotor

                    System.out.print("Datos del vehículo" +
                            "\n Matrícula: ");
                    sMat = sc.nextLine();
                    System.out.print(" Modelo: ");
                    sModelo = sc.nextLine();
                    System.out.print(" Marca: ");
                    sMarca = sc.nextLine();
                    System.out.print(" Tipo de motor (electrico, hibrido enchufable, hibrido, gasolina o diesel): ");
                    sTipoMotor = sc.nextLine();
                    System.out.print(" KILOMETROS RECORRIDOS: ");
                    iKmsRecorr = Integer.valueOf(sc.nextLine());
                    System.out.print(" PRECIO POR DÍA: ");
                    flPrecioDia = Float.valueOf(sc.nextLine());

                    System.out.print("Ahora, introduzca el tipo de vehículo que desee dar de alta: ");
                    String respuesta = sc.nextLine();
                    if (respuesta.compareToIgnoreCase("coche") == 0) {
                        String sTipoCoche;
                        //utilitario, berlina, monovolumen o suv
                        byte byPlazasMaximas, byPuertas;
                        float flVolumenMaletero;
                        System.out.print("Datos del coche" +
                                "\n Tipo de coche (utilitario, berlina, monovolumen o suv): ");
                        sTipoCoche = sc.nextLine();
                        System.out.print(" Número plazas máximas: ");
                        byPlazasMaximas = Byte.valueOf(sc.nextLine());
                        System.out.print(" Número de puertas: ");
                        byPuertas = Byte.valueOf(sc.nextLine());
                        System.out.print(" Volumen del maletero: ");
                        flVolumenMaletero = Float.valueOf(sc.nextLine());

                        Coche nuevocoche = new Coche(sMat, sModelo, sMarca, iKmsRecorr, flPrecioDia, sTipoMotor, byPlazasMaximas, byPuertas, flVolumenMaletero, sTipoCoche);
                        empresa.addVehiculo(nuevocoche);
                        System.out.println("Coche creado con éxito.");

                    } else if (respuesta.compareToIgnoreCase("furgon") == 0) {

                        float flCargaMaximaFurgon;
                        byte byPlazasFurgon;
                        System.out.print("Datos del furgón" +
                                "\n Carga máxima: ");
                        flCargaMaximaFurgon = Float.valueOf(sc.nextLine());
                        System.out.print(" Número de plazas: ");
                        byPlazasFurgon = Byte.valueOf(sc.nextLine());

                        Furgon nuevofurgon = new Furgon(sMat, sModelo, sMarca, iKmsRecorr, flPrecioDia, sTipoMotor, flCargaMaximaFurgon, byPlazasFurgon);
                        empresa.addVehiculo(nuevofurgon);
                        System.out.println("Furgón añadido con éxito.");

                    } else if (respuesta.compareToIgnoreCase("camion") == 0) {

                        float flCargaMaximaCamion;
                        float flLongitud;
                        System.out.print("Datos del camión" +
                                "\n Carga máxima: ");
                        flCargaMaximaCamion = Float.valueOf(sc.nextLine());
                        System.out.print(" Longitud: ");
                        flLongitud = Float.valueOf(sc.nextLine());

                        Camion nuevocamion = new Camion(sMat, sModelo, sMarca, iKmsRecorr, flPrecioDia, sTipoMotor, flCargaMaximaCamion, flLongitud);
                        empresa.addVehiculo(nuevocamion);
                        System.out.println("Camión añadido con éxito.");

                    } else System.out.println("Tipo de vehículo no encontrado.");

                    break;

                case "2":


                    String nombre, apellidos, email, telefono, dni = "", nTarjeta;
                    if (!empresa.hayCliente(dni)) {
                        System.out.println("Introduzca los datos del cliente a continuación");
                        System.out.print(" DNI: ");
                        dni = sc.nextLine();
                        System.out.print(" Nombre: ");
                        nombre = sc.nextLine();
                        System.out.print(" Apellidos: ");
                        apellidos = sc.nextLine();
                        System.out.print(" Email: ");
                        email = sc.nextLine();
                        System.out.print(" Teléfono: ");
                        telefono = sc.nextLine();
                        System.out.print(" Num de tajeta: ");
                        nTarjeta = sc.nextLine();

                        Cliente cliente = new Cliente(nombre, apellidos, email, telefono, dni, nTarjeta);
                        empresa.addCliente(dni, cliente);
                        System.out.println("Cliente añadido con éxito.");
                    }else System.out.println("El cliente ya existe.");
                    break;

                case "3":

                    break;


                case "4":
                    System.out.println("""
                               Escoja el tipo de vehículo: 
                                a. Coche
                                b. Furgón
                                c. Camión
                            """);
                    String tipoveh = sc.nextLine();

                    System.out.println(empresa.listaVehiculos(/*,*/tipoveh));
                    /*
                    String opcion4 = sc.nextLine();
                    switch (opcion4){
                        case "a":
                            System.out.println("");
                            break;

                        case "b":

                            break;

                        case "c":

                            break;

                        default:
                            System.out.println("Opción no válida");
                    }

*/
                    break;

                default:
                    System.out.println("Número fuera de parámetros.");
            }
        }

    }
}