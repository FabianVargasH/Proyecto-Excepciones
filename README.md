# Sistema de Biblioteca - Ejercicio de Excepciones  

Proyecto desarrollado en Java para la gestión de préstamos de materiales en una biblioteca universitaria.

## Descripción

El sistema permite registrar usuarios y materiales, realizar préstamos y devoluciones, manejando situaciones excepcionales mediante una jerarquía de excepciones personalizadas.

## Estructura del proyecto
```
src/vargas/fabian/
├── bl/
│   ├── excepciones/
│   │   ├── BibliotecaException.java
│   │   ├── MaterialNoDisponibleException.java
│   │   ├── MaterialNoEncontradoException.java
│   │   ├── UsuarioNoEncontradoException.java
│   │   └── MaximoPrestamosException.java
│   ├── Material.java
│   ├── Libro.java
│   ├── Revista.java
│   ├── Usuario.java
│   ├── Biblioteca.java
│   └── RegistroErrores.java
└── ui/
    └── Main.java
```

## Conceptos aplicados

- Herencia y clases abstractas
- Interfaces
- Encapsulamiento
- Excepciones personalizadas con try/catch/finally
- Colecciones con ArrayList

## Autor
Fabián Vargas Hidalgo
