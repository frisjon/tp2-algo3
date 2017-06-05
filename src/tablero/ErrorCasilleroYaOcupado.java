package tablero;

public class ErrorCasilleroYaOcupado extends Exception {
	
	public ErrorCasilleroYaOcupado(String mensaje){
		super(mensaje);
	}
}
