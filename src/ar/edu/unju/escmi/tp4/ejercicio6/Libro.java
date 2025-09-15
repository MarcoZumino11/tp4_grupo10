package ar.edu.unju.escmi.tp4.ejercicio6;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int cantidadPaginas;

    // Constructor parametrizado
    public Libro(String isbn, String titulo, String autor, int cantidadPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
    }

    // Métodos accesores
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getCantidadPaginas() { return cantidadPaginas; }

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setCantidadPaginas(int cantidadPaginas) { this.cantidadPaginas = cantidadPaginas; }

    // Método para mostrar los datos del libro
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Cantidad de páginas: " + cantidadPaginas);
        System.out.println("-----------------------------");
    }

    // Método para buscar por título
    public boolean buscar(String tituloBuscado) {
        return this.titulo.equalsIgnoreCase(tituloBuscado);
    }

    // Método para modificar los datos del libro
    public void modificarDatos(String nuevoIsbn, String nuevoTitulo, String nuevoAutor, int nuevasPaginas) {
        this.isbn = nuevoIsbn;
        this.titulo = nuevoTitulo;
        this.autor = nuevoAutor;
        this.cantidadPaginas = nuevasPaginas;
    }
}
