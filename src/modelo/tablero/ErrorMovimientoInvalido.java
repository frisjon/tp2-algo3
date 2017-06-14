package modelo.tablero;

public class ErrorMovimientoInvalido extends RuntimeException {
	
	public ErrorMovimientoInvalido(String mensaje){
		super(mensaje);
	}

}
