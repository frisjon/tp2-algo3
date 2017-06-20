package modelo.personajes;

public class ErrorNoPuedeCambiarEstado extends RuntimeException {
    private static String mensaje = "No se puede transformar. ";
    
    public ErrorNoPuedeCambiarEstado(String condiciones) {
        super(mensaje + condiciones);
    }

}
