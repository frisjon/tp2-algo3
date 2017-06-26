package modelo.personajes;

public class ErrorNoPuedeCambiarEstado extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String mensaje = "No se puede transformar. ";
    
    public ErrorNoPuedeCambiarEstado(String condiciones) {
        super(mensaje + condiciones);
    }

}
