package modelo.personajes;

public class ErrorPersonajeInutilizado extends RuntimeException {
    
	public ErrorPersonajeInutilizado(String mensaje) {
        super(mensaje);
    }
}
