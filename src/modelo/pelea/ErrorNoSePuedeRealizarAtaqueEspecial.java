package modelo.pelea;

public class ErrorNoSePuedeRealizarAtaqueEspecial extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNoSePuedeRealizarAtaqueEspecial(String mensaje){
        super(mensaje);
    }
}
