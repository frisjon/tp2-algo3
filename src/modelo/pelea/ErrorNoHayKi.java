package modelo.pelea;

public class ErrorNoHayKi extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoHayKi(String mensaje){
        super(mensaje);
    }
}
