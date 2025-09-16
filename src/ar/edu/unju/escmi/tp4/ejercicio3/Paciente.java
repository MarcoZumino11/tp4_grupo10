package ar.edu.unju.escmi.tp4.ejercicio3;

// Clase Paciente 
// Representa un paciente con sus datos personales y de historia clínica.
// Implementa Comparable para que el TreeSet pueda mantenerlos ordenados
// automáticamente según el número de historia clínica.
public class Paciente implements Comparable<Paciente> {
    private String dni;
    private String nombre;
    private String apellido;
    private int nroHistoriaClinica;
    private String obraSocial;

    // Constructor por defecto (se van a usar setters para cargar los datos)
    public Paciente() {}

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getNroHistoriaClinica() { return nroHistoriaClinica; }
    public void setNroHistoriaClinica(int nroHistoriaClinica) { this.nroHistoriaClinica = nroHistoriaClinica; }

    public String getObraSocial() { return obraSocial; }
    public void setObraSocial(String obraSocial) { this.obraSocial = obraSocial; }

    // Método toString 
    // Para mostrar un paciente de forma legible en consola
    @Override
    public String toString() {
        return "Paciente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nroHistoriaClinica=" + nroHistoriaClinica +
                ", obraSocial='" + obraSocial + '\'' +
                '}';
    }

    // Define el criterio de orden en el TreeSet:
    // Los pacientes se ordenan por número de historia clínica.
    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(this.nroHistoriaClinica, otro.nroHistoriaClinica);
    }
}