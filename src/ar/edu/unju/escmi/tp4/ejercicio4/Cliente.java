package ar.edu.unju.escmi.tp4.ejercicio4;

// Clase Cliente 
// Modelo de datos para guardar información de un cliente.
// Se usa en el Ejercicio4 junto con un HashSet.
public class Cliente {
    private String dni;         // identificador único del cliente
    private String nombre;      // nombre del cliente
    private String tipoCliente; // puede ser "ocasional" o "frecuente"

    // Constructor con parámetros (se usa al crear clientes desde el menú)
    public Cliente(String dni, String nombre, String tipoCliente) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    // Métodos para consultar los datos de un cliente
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    // Para mostrar un cliente en texto (cuando listamos o buscamos)
    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                '}';
    }

    // Para que el HashSet no guarde dos clientes con el mismo DNI
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente)) return false;
        Cliente other = (Cliente) obj;
        return this.dni.equals(other.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
