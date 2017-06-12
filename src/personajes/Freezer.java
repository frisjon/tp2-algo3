package personajes;

public class Freezer extends Personaje {

    public Freezer() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAFreezerEstado1();

        this.ki = ConstantesPersonajes.FREEZER_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesPersonajes.FREEZER_NOMBRE;
        this.vida = ConstantesPersonajes.FREEZER_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesPersonajes.FREEZER_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesPersonajes.FREEZER_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = ConstantesPersonajes.FREEZER_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = ConstantesPersonajes.FREEZER_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
        this.turnosInutilizados = 0;
    }


    /*
     * Envia un mensaje al Estado actual, para cambiar sus atributos a los de Freezer Estado 1.
     * La transformacion no comsume Ki, por lo tanto, no se verifica ni se lanza excepcion
     *
     */
    public void cambiarAEstado1() {
        this.estado.cambiarAFreezerEstado1();
    }

    /*
     * Envia mensaje al Estado actual, para cambiar atributos a los de Freezer Estado 2.
     * En esta transformacion se requiere un cierto nivel de Ki. Si no lo cumple, lanza excepcion.
     * Nota: El personaje Freezer conoce el nivel de Ki requerido, y no el Estado. Es por eso que
     * se verifica la cantidad requirida de Ki para la transformacion en esta clase. No en Estado.
     */
    public void cambiarAEstado2() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(ConstantesPersonajes.FREEZER_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesPersonajes.FREEZER_ESTADO_2_COSTO);
        this.estado.cambiarAFreezerEstado2();
    }

    /*
     * Se cambia el Estado al de Freezer Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(ConstantesPersonajes.FREEZER_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesPersonajes.FREEZER_ESTADO_3_COSTO);
        this.estado.cambiarAFreezerEstado3();
    }

    /*
     * Determina si el personaje Freezer tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesPersonajes.FREEZER_KI_ATAQUE_ESPECIAL);
    }

    public void consecuenciasAtaqueEspecial(Personaje pj2){}
}
