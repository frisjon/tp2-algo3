package personajes;

public class ErrorNoPuedeCambiarEstado extends Exception {
    public ErrorNoPuedeCambiarEstado(String mensaje){
        super(mensaje);
    }
}
