package vargas.fabian.bl;
import java.util.ArrayList;
import vargas.fabian.bl.excepciones.*;

public class Usuario {
    private int id;
    private String nombre;
    private ArrayList<Material>prestamos;

    public Usuario(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.prestamos = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public int cantidadPrestamos(){
        return prestamos.size();
    }

    public void prestarMaterial(Material material)throws MaximoPrestamosException, MaterialNoDisponibleException{
        if(prestamos.size() >= 3){
            throw new MaximoPrestamosException("El usuario " + nombre + " ya tiene 3 prestamos activos");
        }
        Prestable prestable = (Prestable) material;
        prestable.prestar();
        prestamos.add(material);
    }

    public void devolverMaterial(Material material){
        Prestable prestable = (Prestable) material;
        prestable.devolver();
        int i = 0;
        while(i<prestamos.size()){
            if(prestamos.get(i) == material){
                prestamos.remove(i);
                break;
            }
            i += 1;
        }
    }
}