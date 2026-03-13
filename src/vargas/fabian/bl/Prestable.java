package vargas.fabian.bl;
import vargas.fabian.bl.excepciones.*;

public interface Prestable {
    void prestar() throws MaterialNoDisponibleException;
    void devolver();
    boolean estaPrestado();
}
