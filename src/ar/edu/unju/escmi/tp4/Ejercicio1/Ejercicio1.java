package ar.edu.unju.escmi.tp4.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {

    // Lista dinámica para almacenar jugadores
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    // Scanner para leer entradas desde consola
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        // Ciclo principal del programa: se repite hasta que el usuario elija salir
        do {
            mostrarMenu(); // Mostramos el menú en consola
            opcion = leerEntero("Seleccione una opción: ");
            sc.nextLine(); // Limpia el buffer después de leer el número
            switch (opcion) {
                case 1 -> altaJugador();      // Crear nuevo jugador
                case 2 -> modificarJugador(); // Editar datos de un jugador existente
                case 3 -> eliminarJugador();  // Eliminar jugador por DNI
                case 4 -> mostrarJugadores(); // Mostrar todos los jugadores registrados
                case 5 -> System.out.println("Cantidad de jugadores: " + jugadores.size());
                case 6 -> { 
                    jugadores.clear(); 
                    System.out.println("Lista de jugadores vaciada."); 
                }
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7); // Condición de salida
    }

    // Muestra el menú con todas las opciones disponibles
    private static void mostrarMenu() {
        System.out.println("\n--- Menu de Gestion de Jugadores ---");
        System.out.println("1. Alta de un jugador");
        System.out.println("2. Modificar datos de un jugador");
        System.out.println("3. Eliminar un jugador");
        System.out.println("4. Mostrar todos los jugadores");
        System.out.println("5. Mostrar cantidad de jugadores");
        System.out.println("6. Vaciar lista de jugadores");
        System.out.println("7. Salir");
    }

    // Método para leer un número entero de forma segura
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) { // Validación: si no es número, pide nuevamente
            System.out.println("Por favor, ingrese un número válido.");
            sc.next();
        }
        return sc.nextInt();
    }

    // Método para leer un número decimal (ejemplo: estatura)
    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) { // Validación: si no es número decimal, pide nuevamente
            System.out.println("Por favor, ingrese un número decimal válido.");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine(); // Limpia el buffer
        return valor;
    }

    // Opción 1: Dar de alta un nuevo jugador y agregarlo a la lista
    private static void altaJugador() {
        System.out.println("\n--- Alta de un Jugador ---");
        Jugador j = new Jugador(); // Se usa el constructor por defecto
        System.out.print("Ingrese DNI: ");
        j.setDni(sc.nextLine());
        System.out.print("Ingrese Nombre: ");
        j.setNombre(sc.nextLine());
        System.out.print("Ingrese Equipo: ");
        j.setEquipo(sc.nextLine());
        System.out.print("Ingrese Nacionalidad: ");
        j.setNacionalidad(sc.nextLine());
        j.setEstatura(leerDouble("Ingrese Estatura: "));

        jugadores.add(j); // Agregamos a la lista
        System.out.println("Jugador agregado exitosamente.");
    }

    // Opción 2: Buscar jugador por DNI y modificar sus datos
    private static void modificarJugador() {
        System.out.print("Ingrese DNI del jugador a modificar: ");
        String dni = sc.nextLine();
        for (Jugador j : jugadores) {
            if (j.getDni().equals(dni)) { // Si encuentra coincidencia
                System.out.println("Jugador encontrado:");
                j.mostrarDatos();
                // Pedimos los nuevos datos (menos el DNI, que no se cambia)
                System.out.print("Nuevo nombre: ");
                j.setNombre(sc.nextLine());
                System.out.print("Nuevo equipo: ");
                j.setEquipo(sc.nextLine());
                System.out.print("Nueva nacionalidad: ");
                j.setNacionalidad(sc.nextLine());
                j.setEstatura(leerDouble("Nueva estatura: "));
                return; // Termina el método tras modificar
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    // Opción 3: Eliminar jugador por DNI
    private static void eliminarJugador() {
        System.out.print("Ingrese DNI del jugador a eliminar: ");
        String dni = sc.nextLine();
        for (Jugador j : jugadores) {
            if (j.getDni().equals(dni)) {
                jugadores.remove(j); // Elimina al jugador encontrado
                System.out.println("Jugador eliminado.");
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    // Opción 4: Mostrar todos los jugadores registrados
    private static void mostrarJugadores() {
        if (jugadores.isEmpty()) { // Si la lista está vacía
            System.out.println("No hay jugadores en la lista.");
            return;
        }
        for (Jugador j : jugadores) {
            j.mostrarDatos(); // Se llama al método mostrarDatos() de la clase Jugador
        }
    }
}
