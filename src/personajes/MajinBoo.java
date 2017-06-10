package personajes;

public class MajinBoo extends Personaje {

    public MajinBoo() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAMajinBooEstado1();

        this.ki = ConstantesPersonajes.MAJINBOO_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesPersonajes.MAJINBOO_NOMBRE;
        this.vida = ConstantesPersonajes.MAJINBOO_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesPersonajes.MAJINBOO_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesPersonajes.MAJINBOO_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = ConstantesPersonajes.MAJINBOO_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = ConstantesPersonajes.MAJINBOO_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
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
        if (!this.kiSuficiente(ConstantesPersonajes.MAJINBOO_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesPersonajes.MAJINBOO_ESTADO_2_COSTO);
        this.estado.cambiarAMajinBooEstado2();
    }

    /*
     * Se cambia el Estado al de MajinBoo Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(ConstantesPersonajes.MAJINBOO_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesPersonajes.MAJINBOO_ESTADO_3_COSTO);
        this.estado.cambiarAMajinBooEstado3();
    }

    /*
     * Determina si el personaje MajinBoo tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesPersonajes.MAJINBOO_KI_ATAQUE_ESPECIAL);
    }
}
