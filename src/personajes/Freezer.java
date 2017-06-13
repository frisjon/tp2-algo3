package personajes;

public class Freezer extends Personaje {

    public static final double FREEZER_CANTIDAD_KI_INICIAL = 0;
    public static final double FREEZER_CANTIDAD_VIDA_INICIAL = 400;
    public static final double FREEZER_KI_ATAQUE_ESPECIAL = 20;
    public static final double FREEZER_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL = 0.5;
    public static final double FREEZER_PORCENTAJE_AUMENTO_ATAQUE_PASIVA = 0;
    public static final String FREEZER_NOMBRE = "Freezer";
    public static final String FREEZER_NOMBRE_ATAQUE_ESPECIAL = "Rayo Mortal";

    public static final double FREEZER_ESTADO_1_PODER_DE_PELEA = 20;
    public static final double FREEZER_ESTADO_1_DISTANCIA_DE_ATAQUE = 2;
    public static final double FREEZER_ESTADO_1_VELOCIDAD = 4;
    public static final double FREEZER_ESTADO_1_COSTO = 0;
    public static final int FREEZER_ESTADO_1_ID = 1;

    public static final double FREEZER_ESTADO_2_PODER_DE_PELEA = 40;
    public static final double FREEZER_ESTADO_2_DISTANCIA_DE_ATAQUE = 3;
    public static final double FREEZER_ESTADO_2_VELOCIDAD = 4;
    public static final double FREEZER_ESTADO_2_COSTO = 20;
    public static final int FREEZER_ESTADO_2_ID = 2;

    public static final double FREEZER_ESTADO_3_PODER_DE_PELEA = 50;
    public static final double FREEZER_ESTADO_3_DISTANCIA_DE_ATAQUE = 3;
    public static final double FREEZER_ESTADO_3_VELOCIDAD = 6;
    public static final double FREEZER_ESTADO_3_COSTO = 50;
    public static final int FREEZER_ESTADO_3_ID = 3;
    
    public Freezer() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAFreezerEstado1();

        this.ki = FREEZER_CANTIDAD_KI_INICIAL;
        this.nombre = FREEZER_NOMBRE;
        this.vida = FREEZER_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = FREEZER_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = FREEZER_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = FREEZER_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = FREEZER_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
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
        if (!this.kiSuficiente(FREEZER_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(FREEZER_ESTADO_2_COSTO);
        this.estado.cambiarAFreezerEstado2();
    }

    /*
     * Se cambia el Estado al de Freezer Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(FREEZER_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(FREEZER_ESTADO_3_COSTO);
        this.estado.cambiarAFreezerEstado3();
    }

    /*
     * Determina si el personaje Freezer tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(FREEZER_KI_ATAQUE_ESPECIAL);
    }

    public void consecuenciasAtaqueEspecial(Personaje pj2){}
}
