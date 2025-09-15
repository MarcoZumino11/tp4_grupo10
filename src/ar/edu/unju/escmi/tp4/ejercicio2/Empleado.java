package ar.edu.unju.escmi.tp4.ejercicio2;

public class Empleado {
    private int dni;
    private String nombre;
    private String apellido;
    private double sueldo;
    private char categoria;

    // Constructor parametrizado
    public Empleado(int dni, String nombre, String apellido, double sueldo, char categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.categoria = categoria;
    }

    // Métodos accesores
    public int getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public double getSueldo() { return sueldo; }
    public char getCategoria() { return categoria; }

    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    // Método para mostrar datos
    public void mostrarDatos() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Sueldo: $" + sueldo);
        System.out.println("Categoría: " + categoria);
        System.out.println("-----------------------------");
    }
}

