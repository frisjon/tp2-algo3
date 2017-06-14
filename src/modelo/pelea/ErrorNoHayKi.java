package modelo.pelea;

public class ErrorNoHayKi extends RuntimeException{
    public ErrorNoHayKi(String mensaje){
        super(mensaje);
    }
}
