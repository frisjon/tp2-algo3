package personajes;

import personajes.ConstantesMajinBoo;
import personajes.Personaje;
import motor.ErrorNoHayKi;
import personajes.EstadoPersonaje;

public class MajinBoo extends Personaje {
    public MajinBoo() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAMajinBooEstado1();

        this.ki = ConstantesMajinBoo.MAJINBOO_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesMajinBoo.MAJINBOO_NOMBRE;
        this.vida = ConstantesMajinBoo.MAJINBOO_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesMajinBoo.MAJINBOO_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesMajinBoo.MAJINBOO_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaqueEspecial = ConstantesMajinBoo.MAJINBOO_PORCENTAJE_DANIO_ATAQUE_ESPECIAL;
    }


    /*
     * Envia un mensaje al Estado actual, para cambiar sus atributos a los de MajinBoo Estado 1.
     * La transformacion no comsume Ki, por lo tanto, no se verifica ni se lanza excepcion
     *
     */
    public void cambiarAEstado1() {
        this.estado.cambiarAMajinBooEstado1();
    }

    /*
     * Envia mensaje al Estado actual, para cambiar atributos a los de MajinBoo Estado 2.
     * En esta transformacion se requiere un cierto nivel de Ki. Si no lo cumple, lanza excepcion.
     * Nota: El personaje MajinBoo conoce el nivel de Ki requerido, y no el Estado. Es por eso que
     * se verifica la cantidad requirida de Ki para la transformacion en esta clase. No en Estado.
     */
    public void cambiarAEstado2() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(ConstantesMajinBoo.MAJINBOO_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesMajinBoo.MAJINBOO_ESTADO_2_COSTO);
        this.estado.cambiarAMajinBooEstado2();
    }

    /*
     * Se cambia el Estado al de MajinBoo Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(ConstantesMajinBoo.MAJINBOO_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesMajinBoo.MAJINBOO_ESTADO_3_COSTO);
        this.estado.cambiarAMajinBooEstado3();
    }

    /*
     * Determina si el personaje MajinBoo tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesMajinBoo.MAJINBOO_KI_ATAQUE_ESPECIAL);
    }
}
