package modelo.consumibles;

public class ErrorNoHayTurnosDisponibles extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoHayTurnosDisponibles(String mensaje){
        super(mensaje);
    }

}
