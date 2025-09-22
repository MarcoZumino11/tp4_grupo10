package ar.edu.unju.escmi.tp4.ejercicio3;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Paciente> pacientes = new TreeSet<>(); 
        // TreeSet: mantiene los pacientes ordenados automáticamente
        int opcion;

        // Menú principal
        do {
            System.out.println("\n--- MENÚ PACIENTES ---");
            System.out.println("1 Alta de paciente");
            System.out.println("2 Mostrar todos los pacientes");
            System.out.println("3 Mostrar paciente en la mitad de la lista");
            System.out.println("4 Mostrar primer paciente");
            System.out.println("5 Mostrar último paciente");
            System.out.println("6 Filtrar por historia clínica");
            System.out.println("7 Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Alta: se crea paciente con constructor vacío y se completan los datos con setters
                    Paciente p = new Paciente();
                    System.out.print("DNI: ");
                    p.setDni(scanner.nextLine());
                    System.out.print("Nombre: ");
                    p.setNombre(scanner.nextLine());
                    System.out.print("Apellido: ");
                    p.setApellido(scanner.nextLine());
                    System.out.print("Número de historia clínica: ");
                    p.setNroHistoriaClinica(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Obra social: ");
                    p.setObraSocial(scanner.nextLine());

                    pacientes.add(p);
                    System.out.println("Paciente agregado con éxito.");
                    break;

                case 2:
                    // Mostrar todos los pacientes con stream
                    System.out.println("Lista de pacientes:");
                    pacientes.stream().forEach(System.out::println);
                    break;

                case 3:
                    // Mostrar paciente en la mitad
                    int mitad = pacientes.size() / 2;
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes cargados.");
                    } else {
                        int i = 0;
                        for (Paciente pac : pacientes) {
                            if (i == mitad) {
                                System.out.println("Paciente en la mitad: " + pac);
                                break;
                            }
                            i++;
                        }
                    }
                    break;

                case 4:
                    // Mostrar primer paciente (el de menor historia clínica)
                    if (!pacientes.isEmpty()) {
                        System.out.println("Primer paciente: " + pacientes.first());
                    } else {
                        System.out.println("No hay pacientes cargados.");
                    }
                    break;

                case 5:
                    // Mostrar último paciente (el de mayor historia clínica)
                    if (!pacientes.isEmpty()) {
                        System.out.println("Último paciente: " + pacientes.last());
                    } else {
                        System.out.println("No hay pacientes cargados.");
                    }
                    break;

                case 6:
                    // Filtrar pacientes con historia clínica mayor a un número dado
                    System.out.print("Ingrese número de historia clínica para filtrar: ");
                    int filtro = scanner.nextInt();
                    scanner.nextLine();
                    pacientes.stream()
                            .filter(pac -> pac.getNroHistoriaClinica() > filtro)
                            .forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}