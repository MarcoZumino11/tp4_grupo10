package ar.edu.unju.escmi.tp4.ejercicio4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Cliente> clientes = new HashSet<>(); // colección donde se guardan los clientes
        int opcion;

        // Menú principal 
        // Se repite hasta que el usuario elija salir (opción 6).
        do {
            System.out.println("\nMENÚ CLIENTES");
            System.out.println("1  Crear cliente");
            System.out.println("2  Mostrar los datos de un cliente (por DNI)");
            System.out.println("3  Mostrar todos los clientes");
            System.out.println("4  Mostrar clientes ocasionales y la cantidad");
            System.out.println("5  Mostrar clientes frecuentes y la cantidad");
            System.out.println("6  Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            // Opciones del menú 
            switch (opcion) {
                case 1:
                    // Crear cliente nuevo y agregarlo al HashSet
                    System.out.print("Ingrese DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese tipo de cliente (ocasional/frecuente): ");
                    String tipo = scanner.nextLine().toLowerCase();

                    Cliente cliente = new Cliente(dni, nombre, tipo);
                    if (clientes.add(cliente)) {
                        System.out.println("Cliente agregado con éxito.");
                    } else {
                        System.out.println("El cliente ya existe (DNI duplicado).");
                    }
                    break;

                case 2:
                    // Buscar cliente por DNI y mostrar sus datos
                    System.out.print("Ingrese DNI a buscar: ");
                    String dniBuscar = scanner.nextLine();
                    clientes.stream()
                            .filter(c -> c.getDni().equals(dniBuscar))
                            .forEach(System.out::println);
                    break;

                case 3:
                    // Mostrar todos los clientes
                    System.out.println("Listado de todos los clientes:");
                    clientes.forEach(System.out::println);
                    break;

                case 4:
                    // Mostrar clientes ocasionales y contarlos
                    var ocasionales = clientes.stream()
                            .filter(c -> c.getTipoCliente().equalsIgnoreCase("ocasional"))
                            .collect(Collectors.toList());
                    ocasionales.forEach(System.out::println);
                    System.out.println("Cantidad: " + ocasionales.size());
                    break;

                case 5:
                    // Mostrar clientes frecuentes y contarlos
                    var frecuentes = clientes.stream()
                            .filter(c -> c.getTipoCliente().equalsIgnoreCase("frecuente"))
                            .collect(Collectors.toList());
                    frecuentes.forEach(System.out::println);
                    System.out.println("Cantidad: " + frecuentes.size());
                    break;

                case 6:
                    // Salida del programa
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    // Opción incorrecta
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        scanner.close(); // cerrar el scanner al final
    }
}