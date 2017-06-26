package modelo.tablero;

public class ErrorCasilleroYaOcupado extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorCasilleroYaOcupado(String mensaje){
		super(mensaje);
	}
}
