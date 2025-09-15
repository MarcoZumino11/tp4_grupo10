package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        int opcion;

        do {
            System.out.println("\n--- MENÚ PRODUCTOS ---");
            System.out.println("1 – Alta de producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Buscar un producto");
            System.out.println("4 – Eliminar un producto");
            System.out.println("5 – Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese clave numérica (entero): ");
                    int clave = scanner.nextInt();
                    scanner.nextLine();

                    if (productos.containsKey(clave)) {
                        System.out.println("❌ La clave ya existe. No se puede duplicar.");
                        break;
                    }

                    System.out.print("Ingrese descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese fecha de vencimiento (AAAA-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    LocalDate fechaVenc = LocalDate.parse(fechaStr);

                    Producto nuevo = new Producto(descripcion, precio, fechaVenc);
                    productos.put(clave, nuevo);
                    System.out.println("✅ Producto agregado con éxito.");
                    break;

                case 2:
                    System.out.println("Lista de productos:");
                    Iterator<Map.Entry<Integer, Producto>> it = productos.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Producto> entry = it.next();
                        System.out.println("Clave: " + entry.getKey() + " → " + entry.getValue());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    scanner.nextLine();

                    if (productos.containsKey(claveBuscar)) {
                        System.out.println("Producto encontrado: " + productos.get(claveBuscar));
                    } else {
                        System.out.println("❌ No se encontró producto con esa clave.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese clave de producto a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    scanner.nextLine();

                    if (productos.containsKey(claveEliminar)) {
                        productos.remove(claveEliminar);
                        System.out.println("✅ Producto eliminado.");
                    } else {
                        System.out.println("❌ No se encontró producto con esa clave.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}