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
                    3.   
                    4. 
                    """);

            opcion = sc.nextLine();

            switch (opcion){
                case "0":
                    continuar = false;
                    break;

                case "1":

                    System.out.println("Introduzca los datos genéricos del vehículo");
                    System.out.println(" gnfjgjdh");

                    break;

                case "2":

                    System.out.println("Introduzca los datos del cliente a continuación");
                    System.out.print(" DNI: ");

                    break;

                default:
                    System.out.println("Número fuera de parámetros.");
            }
        }
        
    }
}