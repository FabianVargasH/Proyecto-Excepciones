package vargas.fabian.bl;
import java.util.ArrayList;

import vargas.fabian.bl.excepciones.*;

public class Biblioteca {
    
    private ArrayList<Material> materiales;
    private ArrayList<Usuario> usuarios;

    public Biblioteca(){
        this.materiales = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void registrarMaterial(Material material){
        materiales.add(material);
        System.out.println("Material registrado: " + material.getTitulo());
    }

    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public Material buscarMaterial (String id) throws MaterialNoEncontradoException{
        int i = 0;
        while(i< materiales.size()){
            if(materiales.get(i).getId().equals(id)){
                return materiales.get(i);
            }
            i +=1;
        }
        throw new MaterialNoEncontradoException("No se encontro Material con ID: " + id);
    }

    public Usuario buscarUsuario(int id) throws UsuarioNoEncontradoException{
        int i =0;
        while(i<usuarios.size()){
            if(usuarios.get(i).getId()==id){
                return usuarios.get(i);
            }
            i += 1;
        }
        throw new UsuarioNoEncontradoException("No se encontro usuario con ID: " + id);
    }

    public void prestarMaterial(int usuarioId, String materialId)throws UsuarioNoEncontradoException, MaterialNoDisponibleException, MaterialNoEncontradoException, MaximoPrestamosException{
        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);
        usuario.prestarMaterial(material);
        System.out.println("Prestamo exitoso: " + usuario.getNombre() + " llevo " + material.getTitulo());
    }

    public void devolverMaterial(int usuarioId, String materialId)throws UsuarioNoEncontradoException, MaterialNoEncontradoException{
        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);
        usuario.devolverMaterial(material);
        System.out.println("Devolucion exitosa: " + usuario.getNombre() + " devolvio " + material.getTitulo());
    }

    public void mostrarEstado(){
        System.out.println("\n--ESTADO DE LA BIBLIOTECA--");
        int i = 0;
        while(i < materiales.size()){
            String estado;
            if(materiales.get(i).estaPrestado() == true){
                estado = "PRESTADO";
            } else {
                estado = "DISPONIBLE";
            }
            System.out.println("[" + materiales.get(i).getId() + "] " + materiales.get(i).getTitulo() + " - " + estado);
            i += 1;
        }
        System.out.println("- - - - - -");
    }
}