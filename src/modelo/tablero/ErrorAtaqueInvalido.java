package modelo.tablero;

public class ErrorAtaqueInvalido extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorAtaqueInvalido(String mensaje){
		super(mensaje);
	}

}
