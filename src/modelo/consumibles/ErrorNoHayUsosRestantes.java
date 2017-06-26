package modelo.consumibles;

/**
 * Excepcion que se lanzara cuando se intente reducir usos de un consumible sin usos restantes.
 * 
 * @author Thomas
 *
 */
public class ErrorNoHayUsosRestantes extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoHayUsosRestantes(String mensaje){
        super(mensaje);
    }
}