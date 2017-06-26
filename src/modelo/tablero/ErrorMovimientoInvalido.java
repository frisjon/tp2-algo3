package modelo.tablero;

public class ErrorMovimientoInvalido extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorMovimientoInvalido(String mensaje){
		super(mensaje);
	}

}
