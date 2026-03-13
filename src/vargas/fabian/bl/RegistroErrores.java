package vargas.fabian.bl;

public class RegistroErrores {
    
    public static void registrar(Exception e){
        String nombreError = e.getClass().getSimpleName();
        String mensaje = e.getMessage();
        String linea = "Error: " + nombreError + " -" + mensaje;

        System.out.println(linea);
    }
}
