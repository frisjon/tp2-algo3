package modelo.consumibles;

/**
 * Excepcion que se lanzara cuando se intente reducir turnos de un consumible instantaneo.
 * 
 * @author Thomas
 *
 */
public class ErrorConsumibleInstantaneo extends RuntimeException{
    public ErrorConsumibleInstantaneo(String mensaje){
        super(mensaje);
    }
}