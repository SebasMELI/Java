package demo;

public class Libro {

    private String titulo;
    private String isbn;
    private String autor;

    public Libro()
    {
        this.titulo = "Harry Potter";
        this.isbn = "9780545582889";
        this.autor = "Rowling, J. K.";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String prestamo(){
        return "Prestamo: " + this.toString();
    }

    public String devolucion(){
        return "Devolucion: " + this.toString();
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + this.titulo + '\'' +
                ", isbn=" + this.isbn +
                ", autor='" + this.autor + '\'' +
                '}';
    }
}
