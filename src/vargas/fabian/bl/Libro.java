package vargas.fabian.bl;
import vargas.fabian.bl.excepciones.*;

public class Libro extends Material implements Prestable{
    private String autor;
    private String isbn;

    public Libro(String id, String titulo, String autor, String isbn) {
        super(id, titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }
    public String getIsbn() {
        return isbn;
    }

    @Override
    public void prestar() throws MaterialNoDisponibleException {
        if (estaPrestado() == true) {
            throw new MaterialNoDisponibleException("El libro " + getTitulo() + " ya esta prestado");
        }
        setEstaPrestado(true);
    }

    @Override
    public void devolver() {
        setEstaPrestado(false);
    }
}
