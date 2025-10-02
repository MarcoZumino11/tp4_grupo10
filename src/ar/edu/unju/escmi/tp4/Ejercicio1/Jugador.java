package ar.edu.unju.escmi.tp4.Ejercicio1;

public class Jugador {

    // Atributos de la clase

    private String dni;
    private String nombre;
    private String equipo;
    private String nacionalidad;
    private double estatura;

    // Constructores

    // Constructor por defecto (vacío)
    // Se usa cuando creamos un objeto sin pasar parámetros
    public Jugador() {
    }

    // Constructor parametrizado
    // Permite inicializar todos los atributos al crear el objeto
    public Jugador(String dni, String nombre, String equipo, String nacionalidad, double estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.equipo = equipo;
        this.nacionalidad = nacionalidad;
        this.estatura = estatura;
    }

    // Métodos Getters y Setters

    // El método getDni() devuelve el valor del atributo dni
    public String getDni() { 
        return dni; 
    }
    // El método setDni() permite asignar un valor al atributo dni
    public void setDni(String dni) { 
        this.dni = dni; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getEquipo() { 
        return equipo; 
    }
    public void setEquipo(String equipo) { 
        this.equipo = equipo; 
    }

    public String getNacionalidad() { 
        return nacionalidad; 
    }
    public void setNacionalidad(String nacionalidad) { 
        this.nacionalidad = nacionalidad; 
    }

    public double getEstatura() { 
        return estatura; 
    }
    public void setEstatura(double estatura) { 
        this.estatura = estatura; 
    }

    // Método para mostrar datos

    public void mostrarDatos() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Equipo: " + equipo);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Estatura: " + estatura + " metros");
    }

}
