package modelo.pelea;

public class ErrorNoSePuedeRealizarAtaqueEspecial extends RuntimeException{
    public ErrorNoSePuedeRealizarAtaqueEspecial(String mensaje){
        super(mensaje);
    }
}
