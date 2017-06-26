package modelo.tablero;

public class ErrorNoHayObjeto extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoHayObjeto(String mensaje){
		super(mensaje);
	}
	
}
