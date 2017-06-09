package personajes;

import personajes.ConstantesCell;
import personajes.Personaje;
import personajes.EstadoPersonaje;
import personajes.ErrorNoPuedeCambiarEstado;

public class Cell extends Personaje {
	
    private int cantidadAbsorciones;
    
    public Cell() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarACellEstado1();

        this.ki = ConstantesCell.CELL_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesCell.CELL_NOMBRE;
        this.vida = ConstantesCell.CELL_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesCell.CELL_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesCell.CELL_KI_ATAQUE_ESPECIAL;
        this.cantidadAbsorciones = 0;
        this.aumentoAtaqueEspecial = ConstantesCell.CELL_PORCENTAJE_DANIO_ATAQUE_ESPECIAL;
    }


    /*
     * Envia un mensaje al Estado actual, para cambiar sus atributos a los de Cell Estado 1.
     * La transformacion no comsume Ki, por lo tanto, no se verifica ni se lanza excepcion
     *
     */
    public void cambiarAEstado1() {
        this.estado.cambiarACellEstado1();
    }

    /*
     * Envia mensaje al Estado actual, para cambiar atributos a los de Cell Estado 2.
     * En esta transformacion se requiere un cierto nivel de Ki. Si no lo cumple, lanza excepcion.
     * Nota: El personaje Cell conoce el nivel de Ki requerido, y no el Estado. Es por eso que
     * se verifica la cantidad requirida de Ki para la transformacion en esta clase. No en Estado.
     */
    public void cambiarAEstado2() throws ErrorNoPuedeCambiarEstado {
        if (!(ConstantesCell.CELL_ESTADO_2_COSTO <= this.cantidadAbsorciones))
            throw new ErrorNoPuedeCambiarEstado(ConstantesCell.CELL_MENSAJE_ABSORCIONES_INSUFICIENTES);
        this.estado.cambiarACellEstado2();
    }

    /*
     * Se cambia el Estado al de Cell Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!(ConstantesCell.CELL_ESTADO_3_COSTO <= this.cantidadAbsorciones))
            throw new ErrorNoPuedeCambiarEstado(ConstantesCell.CELL_MENSAJE_ABSORCIONES_INSUFICIENTES);
        this.estado.cambiarACellEstado3();
    }
    
    public void aumentarCantidadAbsorciones() {
    	this.quitarKi(ConstantesCell.CELL_KI_ATAQUE_ESPECIAL);
    	this.cantidadAbsorciones += 1;
    }

    /*
     * Determina si el personaje Cell tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesCell.CELL_KI_ATAQUE_ESPECIAL);
    }
}
