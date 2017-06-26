package modelo.personajes;

public class ErrorPersonajeInutilizado extends RuntimeException {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorPersonajeInutilizado(String mensaje) {
        super(mensaje);
    }
}
