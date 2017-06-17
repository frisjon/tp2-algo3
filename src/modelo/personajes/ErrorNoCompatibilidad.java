package modelo.personajes;

public class ErrorNoCompatibilidad extends RuntimeException{
    public ErrorNoCompatibilidad(String mensaje){
        super(mensaje);
    }

}
