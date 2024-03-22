package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        String opcion;

        Empresa empresa = new Empresa("Sofenkro INC.");

        while (continuar) {
            System.out.println("""
                                        
                    1. Dar alta vehiculo
                    2. Dar alta cliente
                    3. Alquilar vehiculo determinado para un cliente determinado  
                    4. Mostrar lista de vehiculos
                    5. Devolver vehículo y mostrar precio a cobrar
                                        
                    """);

            opcion = sc.nextLine();

            switch (opcion) {
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
                    if (!empresa.hayCliente(dni)) {
                        empresa.addCliente(dni, cliente);
                        System.out.println("Cliente añadido con éxito.");
                    } else System.out.println("El cliente ya existe.");
                    break;

                case "3":

                    System.out.print("Introduzca el dni del cliente: ");
                    String dnialq = sc.nextLine();
                    if (empresa.hayCliente(dnialq)) {
                        System.out.print("Ahora la matrícula del vehículo a alquilar: ");
                        String matralq = sc.nextLine();
                        if (empresa.hayVehiculo(matralq)) {
                            System.out.print("Indique la fecha de inicio: ");
                            String fechainicio = sc.nextLine();
                            System.out.print("Ahora el número de días que va a ser alquilado: ");
                            int diasalq = Integer.valueOf(sc.nextLine());
                            if (empresa.alquilarVehiculo(dnialq, matralq, fechainicio, diasalq)) {
                                System.out.println("Reserva realizada con éxito.");
                            } else System.out.println("No se ha podido realizar la reserva.");
                        } else System.out.println("El vehículo no está creado todavía.");
                    } else System.out.println("El cliente no existe.");
                    break;


                case "4":
                    System.out.println("""
                               Escoja el tipo de vehículo: 
                                Coche
                                Furgón
                                Camión
                            """);
                    String tipoveh = sc.nextLine();

                    switch (tipoveh) {
                        case "coche":
                            int plazas;
                            String tipoMCoche;
                            System.out.println("Coches con datos específicos --> ");
                            System.out.print(" Número de plazas: ");
                            plazas = Integer.valueOf(sc.nextLine());
                            System.out.print(" Tipo: ");
                            tipoMCoche = sc.nextLine();
                            System.out.println(empresa.listaCoches(tipoveh, plazas, tipoMCoche));
                            break;

                        case "furgon":
                            float cargamayor;
                            int plazasfurg;
                            System.out.println("Furgones con datos específicos --> ");
                            System.out.print(" KG de carga máx: ");
                            cargamayor = Float.valueOf(sc.nextLine());
                            System.out.print(" Plazas: ");
                            plazasfurg = Integer.valueOf(sc.nextLine());
                            System.out.println(empresa.listaFurgon(tipoveh, cargamayor, plazasfurg));
                            break;

                        case "camion":
                            float cargamayorcam, longitudcam;
                            System.out.println("Camiones con datos específicos --> ");
                            System.out.print(" KG de carga máx: ");
                            cargamayorcam = Float.valueOf(sc.nextLine());
                            System.out.print(" Longitud: ");
                            longitudcam = Integer.valueOf(sc.nextLine());
                            System.out.println(empresa.listaCamion(tipoveh, cargamayorcam, longitudcam));
                            break;

                        default:
                            System.out.println("Opción no válida");
                    }
                    break;

                case "5":
                    System.out.print("Introduzca el dni del cliente: ");
                    String dnidev = sc.nextLine();
                    if (empresa.hayCliente(dnidev)) {
                        System.out.print("Ahora la matrícula del vehículo a devolver: ");
                        String matrdev = sc.nextLine();
                        if (empresa.hayVehiculoAlquilado(matrdev)) {

/*
                            System.out.print("Indique la fecha de inicio: ");
                            String fechainicio = sc.nextLine();
                            System.out.print("Ahora el número de días que va a ser alquilado: ");
                            int diasalq = Integer.valueOf(sc.nextLine());
                            if (empresa.alquilarVehiculo(dnidev, matrdev, fechainicio, diasalq)) {
                                System.out.println("Reserva realizada con éxito.");
                            } else System.out.println("No se ha podido realizar la reserva.");
*/


                        } else System.out.println("El vehículo no está creado todavía.");
                    } else System.out.println("El cliente no existe.");

                    break;

                default:
                    System.out.println("Número fuera de parámetros.");
            }
        }

    }
}