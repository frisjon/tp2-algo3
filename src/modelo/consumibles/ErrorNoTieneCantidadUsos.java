package modelo.consumibles;

public class ErrorNoTieneCantidadUsos extends RuntimeException{
    public ErrorNoTieneCantidadUsos(String mensaje){
        super(mensaje);
    }
}
