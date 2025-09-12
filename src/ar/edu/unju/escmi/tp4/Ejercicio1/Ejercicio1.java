package ar.edu.unju.escmi.tp4.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {

    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            sc.nextLine(); 
            switch (opcion) {
                case 1 -> altaJugador();
                case 2 -> modificarJugador();
                case 3 -> eliminarJugador();
                case 4 -> mostrarJugadores();
                case 5 -> System.out.println("Cantidad de jugadores: " + jugadores.size());
                case 6 -> { jugadores.clear(); System.out.println("Lista de jugadores vaciada."); }
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);
    }

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

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            sc.next();
        }
        return sc.nextInt();
    }

private static double leerDouble(String mensaje) {
    System.out.print(mensaje);
    while (!sc.hasNextDouble()) {
        System.out.println("Por favor, ingrese un número decimal válido.");
        sc.next();
    }
    double valor = sc.nextDouble();
    sc.nextLine(); 
    return valor;
}

    private static void altaJugador() {
        System.out.println("\n--- Alta de un Jugador ---");
        Jugador j = new Jugador();
        System.out.print("Ingrese DNI: ");
        j.setDni(sc.nextLine());
        System.out.print("Ingrese Nombre: ");
        j.setNombre(sc.nextLine());
        System.out.print("Ingrese Equipo: ");
        j.setEquipo(sc.nextLine());
        System.out.print("Ingrese Nacionalidad: ");
        j.setNacionalidad(sc.nextLine());
        j.setEstatura(leerDouble("Ingrese Estatura: "));

        jugadores.add(j);
        System.out.println("Jugador agregado exitosamente.");
    }

    private static void modificarJugador() {
        System.out.print("Ingrese DNI del jugador a modificar: ");
        String dni = sc.nextLine();
        for (Jugador j : jugadores) {
            if (j.getDni().equals(dni)) {
                System.out.println("Jugador encontrado:");
                j.mostrarDatos();
                System.out.print("Nuevo nombre: ");
                j.setNombre(sc.nextLine());
                System.out.print("Nuevo equipo: ");
                j.setEquipo(sc.nextLine());
                System.out.print("Nueva nacionalidad: ");
                j.setNacionalidad(sc.nextLine());
                System.out.print("Nueva estatura: ");
                j.setEstatura(leerDouble("Nueva estatura: "));
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    private static void eliminarJugador() {
        System.out.print("Ingrese DNI del jugador a eliminar: ");
        String dni = sc.nextLine();
        for (Jugador j : jugadores) {
            if (j.getDni().equals(dni)) {
                jugadores.remove(j);
                System.out.println("Jugador eliminado.");
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    private static void mostrarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en la lista.");
            return;
        }
        for (Jugador j : jugadores) {
            j.mostrarDatos();
        }
    }
}

              
              

