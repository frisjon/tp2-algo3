package personajes;

import personajes.ConstantesCell;
import personajes.Personaje;
import personajes.EstadoPersonaje;
import personajes.ErrorCambiarEstadoCondicionesNoCumplidas;

public class Cell extends Personaje {
    private int cantidadAtaquesEspecialesRealizados;
    public Cell() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarACellEstado1();

        this.ki = ConstantesCell.CELL_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesCell.CELL_NOMBRE;
        this.vida = ConstantesCell.CELL_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesCell.CELL_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesCell.CELL_KI_ATAQUE_ESPECIAL;
        this.cantidadAtaquesEspecialesRealizados = 0;
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
    public void cambiarAEstado2() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        if (!this.kiSuficiente(ConstantesCell.CELL_ESTADO_2_COSTO))
            throw new ErrorCambiarEstadoCondicionesNoCumplidas("Ki insuficiente.");
        if (!(ConstantesCell.CELL_ESTADO_2_COSTO_ATAQUE_ESPECIAL <= this.cantidadAtaquesEspecialesRealizados))
            throw new ErrorCambiarEstadoCondicionesNoCumplidas(ConstantesCell.CELL_MENSAJE_ABSORCIONES_INSUFICIENTES);
        this.quitarKi(ConstantesCell.CELL_ESTADO_2_COSTO);
        this.estado.cambiarACellEstado2();
    }

    /*
     * Se cambia el Estado al de Cell Estado 3
     */
    public void cambiarAEstado3() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        if (!this.kiSuficiente(ConstantesCell.CELL_ESTADO_3_COSTO))
            throw new ErrorCambiarEstadoCondicionesNoCumplidas("Ki insuficiente.");
        if (!(ConstantesCell.CELL_ESTADO_3_COSTO_ATAQUE_ESPECIAL <= this.cantidadAtaquesEspecialesRealizados))
            throw new ErrorCambiarEstadoCondicionesNoCumplidas(ConstantesCell.CELL_MENSAJE_ABSORCIONES_INSUFICIENTES);
        this.quitarKi(ConstantesCell.CELL_ESTADO_3_COSTO);
        this.estado.cambiarACellEstado3();
    }

    /*
     * Determina si el personaje Cell tiene Ki suficiente para realizar el ataque especial.
     */
    @Override
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesCell.CELL_KI_ATAQUE_ESPECIAL);
    }
}
