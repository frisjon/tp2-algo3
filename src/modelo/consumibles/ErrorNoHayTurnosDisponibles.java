package modelo.consumibles;

public class ErrorNoHayTurnosDisponibles extends RuntimeException{
    public ErrorNoHayTurnosDisponibles(String mensaje){
        super(mensaje);
    }

}
