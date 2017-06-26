package modelo.consumibles;

public class ErrorNoTieneCantidadUsos extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoTieneCantidadUsos(String mensaje){
        super(mensaje);
    }
}
