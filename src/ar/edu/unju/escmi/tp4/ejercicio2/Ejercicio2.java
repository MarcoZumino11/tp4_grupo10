package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Scanner para leer datos desde la terminal
        Scanner scanner = new Scanner(System.in);

        // HashMap donde la clave es String (dni + categoría) y el valor es un objeto Empleado
        HashMap<String, Empleado> empleados = new HashMap<>();

        int opcion;

        // Menú interactivo que se repite hasta que el usuario elija salir
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1 - Alta del empleado");
            System.out.println("2 - Eliminar empleado");
            System.out.println("3 - Modificar sueldo");
            System.out.println("4 - Consultar datos de un empleado");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner

            switch (opcion) {
                case 1:
                    // Alta de empleado usando constructor parametrizado
                    System.out.print("Ingrese DNI: ");
                    int dni = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese apellido: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Ingrese sueldo: ");
                    double sueldo = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ingrese categoría (A/B/C): ");
                    char categoria = scanner.nextLine().toUpperCase().charAt(0);

                    // Se crea el objeto Empleado y se genera la clave compuesta
                    Empleado nuevo = new Empleado(dni, nombre, apellido, sueldo, categoria);
                    String clave = dni + String.valueOf(categoria);

                    // Se almacena en el HashMap
                    empleados.put(clave, nuevo);
                    System.out.println("Empleado agregado con clave: " + clave);
                    break;

                case 2:
                    // Mostrar todos los empleados antes de eliminar
                    System.out.println("Empleados registrados:");
                    Iterator<Map.Entry<String, Empleado>> iterator = empleados.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Empleado> entry = iterator.next();
                        System.out.println("Clave: " + entry.getKey());
                        entry.getValue().mostrarDatos();
                    }

                    // Solicita la clave del empleado a eliminar
                    System.out.print("Ingrese la clave del empleado a eliminar: ");
                    String claveEliminar = scanner.nextLine();

                    // Verifica si la clave existe y elimina el empleado
                    if (empleados.containsKey(claveEliminar)) {
                        empleados.remove(claveEliminar);
                        System.out.println("Empleado eliminado.");
                    } else {
                        System.out.println("No existe un empleado con esa clave.");
                    }
                    break;

                case 3:
                    // Modificación de sueldo
                    System.out.print("Ingrese la clave del empleado para modificar sueldo: ");
                    String claveModificar = scanner.nextLine();

                    if (empleados.containsKey(claveModificar)) {
                        Empleado emp = empleados.get(claveModificar);
                        System.out.print("Ingrese nuevo sueldo: ");
                        double nuevoSueldo = scanner.nextDouble();
                        scanner.nextLine();

                        emp.setSueldo(nuevoSueldo);
                        System.out.println("Sueldo actualizado.");
                    } else {
                        System.out.println("No existe un empleado con esa clave.");
                    }
                    break;

                case 4:
                    // Consulta de datos de un empleado
                    System.out.print("Ingrese la clave del empleado a consultar: ");
                    String claveConsulta = scanner.nextLine();

                    if (empleados.containsKey(claveConsulta)) {
                        Empleado emp = empleados.get(claveConsulta);
                        emp.mostrarDatos();
                    } else {
                        System.out.println("No existe un empleado con esa clave.");
                    }
                    break;

                case 5:
                    // Salida del programa
                    System.out.println("Fin del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        // Cierre del scanner 
        scanner.close();
    }
}

