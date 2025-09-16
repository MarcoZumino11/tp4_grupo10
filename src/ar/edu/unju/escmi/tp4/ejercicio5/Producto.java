package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;

// Clase Producto 
// Representa un producto con sus datos básicos:
// - descripción: texto que identifica el producto
// - precio: valor en dinero
// - fechaVencimiento: fecha límite de uso (usando LocalDate)
public class Producto {
    private String descripcion;
    private double precio;
    private LocalDate fechaVencimiento;

    // Constructor 
    // Se usa para crear un producto con todos sus datos
    public Producto(String descripcion, double precio, LocalDate fechaVencimiento) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getters 
    // Métodos para consultar los datos de un producto
    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    // toString 
    // Devuelve un texto con la info del producto (se usa al imprimirlo en consola)
    @Override
    public String toString() {
        return "Producto{" +
                "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}
