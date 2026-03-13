package vargas.fabian.bl;

public abstract class Material{

    private String id;
    private String titulo;
    private boolean prestado;

    public Material(String id, String titulo){
        this.id = id;
        this.titulo = titulo;
        this.prestado = false;
    }

    public String getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }

    public boolean estaPrestado(){
        return prestado;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setEstaPrestado(boolean estaPrestado){
        this.prestado = estaPrestado;
    }

    public void setPrestado(boolean valor){
        this.prestado = valor;
    }
}
