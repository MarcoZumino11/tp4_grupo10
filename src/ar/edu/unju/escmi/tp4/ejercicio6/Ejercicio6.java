package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> biblioteca = new ArrayList<>();
        int opcion;

        // Menú interactivo que se repite hasta que el usuario elija salir
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1 Alta de Libro");
            System.out.println("2 Mostrar libros");
            System.out.println("3 Buscar y mostrar un libro");
            System.out.println("4 Modificar datos de un libro");
            System.out.println("5 Borrar libro");
            System.out.println("6 Eliminar un autor y sus libros");
            System.out.println("0 Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    // Alta de libro usando constructor
                    System.out.print("Ingrese ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Ingrese título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese cantidad de páginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine();

                    Libro nuevoLibro = new Libro(isbn, titulo, autor, paginas);
                    biblioteca.add(nuevoLibro);
                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:
                    // Mostrar todos los libros
                    if (biblioteca.isEmpty()) {
                        System.out.println("No hay libros registrados.");
                    } else {
                        for (Libro libro : biblioteca) {
                            libro.mostrarDatos();
                        }
                    }
                    break;

                case 3:
                    // Buscar libro por título
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String tituloBuscado = scanner.nextLine();
                    boolean encontrado = false;

                    for (Libro libro : biblioteca) {
                        if (libro.buscar(tituloBuscado)) {
                            libro.mostrarDatos();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:
                    // Modificar datos de un libro
                    System.out.print("Ingrese el título del libro a modificar: ");
                    String tituloModificar = scanner.nextLine();
                    boolean modificado = false;

                    for (Libro libro : biblioteca) {
                        if (libro.buscar(tituloModificar)) {
                            System.out.print("Nuevo ISBN: ");
                            String nuevoIsbn = scanner.nextLine();
                            System.out.print("Nuevo título: ");
                            String nuevoTitulo = scanner.nextLine();
                            System.out.print("Nuevo autor: ");
                            String nuevoAutor = scanner.nextLine();
                            System.out.print("Nueva cantidad de páginas: ");
                            int nuevasPaginas = scanner.nextInt();
                            scanner.nextLine();

                            libro.modificarDatos(nuevoIsbn, nuevoTitulo, nuevoAutor, nuevasPaginas);
                            System.out.println("Datos modificados correctamente.");
                            modificado = true;
                            break;
                        }
                    }

                    if (!modificado) {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 5:
                    // Borrar libro por título
                    System.out.print("Ingrese el título del libro a borrar: ");
                    String tituloBorrar = scanner.nextLine();
                    Iterator<Libro> iterador = biblioteca.iterator();
                    boolean borrado = false;

                    while (iterador.hasNext()) {
                        Libro libro = iterador.next();
                        if (libro.buscar(tituloBorrar)) {
                            iterador.remove();
                            System.out.println("Libro eliminado.");
                            borrado = true;
                            break;
                        }
                    }

                    if (!borrado) {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 6:
                    // Eliminar todos los libros de un autor por ISBN
                    System.out.print("Ingrese el ISBN del autor a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    Iterator<Libro> it = biblioteca.iterator();
                    boolean autorEliminado = false;

                    while (it.hasNext()) {
                        Libro libro = it.next();
                        if (libro.getIsbn().equalsIgnoreCase(isbnEliminar)) {
                            it.remove();
                            autorEliminado = true;
                        }
                    }

                    if (autorEliminado) {
                        System.out.println("Libros del autor eliminados.");
                    } else {
                        System.out.println("No se encontraron libros con ese ISBN.");
                    }
                    break;

                case 0:
                    System.out.println("Fin del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        // Cierre del scanner para liberar recursos
        scanner.close();
    }
}
