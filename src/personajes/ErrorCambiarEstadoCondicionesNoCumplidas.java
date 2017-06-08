package personajes;

public class ErrorCambiarEstadoCondicionesNoCumplidas extends Exception {
    private static String mensaje = "No se puede cambiar de Estado. ";
    
    public ErrorCambiarEstadoCondicionesNoCumplidas(String condiciones) {
        super(mensaje + condiciones);
    }

}
