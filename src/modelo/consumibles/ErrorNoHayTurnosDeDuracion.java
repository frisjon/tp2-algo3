package modelo.consumibles;

public class ErrorNoHayTurnosDeDuracion extends RuntimeException{
    public ErrorNoHayTurnosDeDuracion(String mensaje){
        super(mensaje);
    }
  }
