package modelo.personajes;

public class ErrorNoCompatibilidad extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoCompatibilidad(String mensaje){
        super(mensaje);
    }

}
