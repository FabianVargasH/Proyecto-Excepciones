package vargas.fabian.bl;
import vargas.fabian.bl.excepciones.*;

public class Revista extends Material implements Prestable{

    private int numero;

    public Revista(String id, String titulo, int numero){
        super(id, titulo);
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }

    @Override
    public void prestar() throws MaterialNoDisponibleException{
        if(estaPrestado() == true){
             throw new MaterialNoDisponibleException("La revista " + getTitulo() + " ya esta prestada");
        }
        setEstaPrestado(true);
    }

    @Override
    public void devolver(){
        setEstaPrestado(false);
    }
}
