package modelo.tablero;

public class ErrorCasilleroYaOcupado extends RuntimeException {
	
	public ErrorCasilleroYaOcupado(String mensaje){
		super(mensaje);
	}
}
