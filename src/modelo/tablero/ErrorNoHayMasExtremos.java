package modelo.tablero;

public class ErrorNoHayMasExtremos extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoHayMasExtremos(String mensaje){
		super(mensaje);
	}
}
