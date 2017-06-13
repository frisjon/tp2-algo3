package tablero;

public class ErrorNoHayMasExtremos extends RuntimeException {
	
	public ErrorNoHayMasExtremos(String mensaje){
		super(mensaje);
	}
}
