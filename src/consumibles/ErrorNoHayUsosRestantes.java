package consumibles;

/**
 * Excepcion que se lanzara cuando se intente reducir usos de un consumible sin usos restantes.
 * 
 * @author Thomas
 *
 */
public class ErrorNoHayUsosRestantes extends RuntimeException{
    public ErrorNoHayUsosRestantes(String mensaje){
        super(mensaje);
    }
}