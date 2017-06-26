package modelo.consumibles;

public class ErrorNoHayTurnosDeDuracion extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoHayTurnosDeDuracion(String mensaje){
        super(mensaje);
    }
  }
