package modelo.personajes;

public class ErrorNoPuedeCambiarEstado extends RuntimeException {
    private static String mensaje = "No se puede cambiar de Estado. ";
    
    public ErrorNoPuedeCambiarEstado(String condiciones) {
        super(mensaje + condiciones);
    }

}