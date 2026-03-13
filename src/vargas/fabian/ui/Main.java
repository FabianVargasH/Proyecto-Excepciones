package vargas.fabian.ui;
import vargas.fabian.bl.*;
import vargas.fabian.bl.excepciones.*;

public class Main {
    Biblioteca biblioteca = new Biblioteca();
    public static void main(String[] args) {
        Main programa = new Main();
        programa.registrarDatos();
        programa.ejecutarPrestamos();
        programa.ejecutarDevoluciones();
        programa.mostrarEstado();
    }

    void registrarDatos() {
        biblioteca.registrarMaterial(new Libro("L001", "El Quijote", "Cervantes", "111"));
        biblioteca.registrarMaterial(new Libro("L002", "Excepciones", "Fabian Vargas", "222"));
        biblioteca.registrarMaterial(new Libro("L003", "1984", "Jorge el Currioso", "333"));
        biblioteca.registrarMaterial(new Revista("R001", "National Geographic", 245));
        biblioteca.registrarMaterial(new Revista("R002", "Revista de Cenfo", 312));

        biblioteca.registrarUsuario(new Usuario(1, "Ana Lopez"));
        biblioteca.registrarUsuario(new Usuario(2, "Carlos Mendez"));
    }

    void ejecutarPrestamos() {
        System.out.println("\nCaso 1: Prestamos exitosos");
        try {
            biblioteca.prestarMaterial(1, "L001");
            biblioteca.prestarMaterial(1, "R001");
            biblioteca.prestarMaterial(2, "L002");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.\n");
        }

        System.out.println("\nCaso 2: Material ya prestado");
        try {
            biblioteca.prestarMaterial(2, "L001");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.\n");
        }

        System.out.println("\nCaso 3: Usuario no existe");
        try {
            biblioteca.prestarMaterial(99, "L003");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.\n");
        }

        System.out.println("\nCaso 4: Material no existe");
        try {
            biblioteca.prestarMaterial(1, "X999");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.\n");
        }

        System.out.println("\nCaso 5: Maximo de prestamos");
        try {
            biblioteca.prestarMaterial(1, "L003");
            biblioteca.prestarMaterial(1, "R002");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.\n");
        }
    }
    void ejecutarDevoluciones() {
        System.out.println("\nCaso 6: Devolucion");
        try {
            biblioteca.devolverMaterial(1, "L001");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.\n");
        }
    }
    void mostrarEstado() {
        biblioteca.mostrarEstado();
    }
}
