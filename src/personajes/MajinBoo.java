package personajes;

public class MajinBoo extends Personaje {

    public static final double MAJINBOO_CANTIDAD_KI_INICIAL = 0;
    public static final double MAJINBOO_CANTIDAD_VIDA_INICIAL = 300;
    public static final double MAJINBOO_KI_ATAQUE_ESPECIAL = 30;
    public static final double MAJINBOO_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL = 0;
    public static final double MAJINBOO_PORCENTAJE_AUMENTO_ATAQUE_PASIVA = 0;
    public static final int MAJINBOO_TURNOS_QUE_INUTILIZA_OPONENTE = 3;
    public static final String MAJINBOO_NOMBRE = "MajinBoo";
    public static final String MAJINBOO_NOMBRE_ATAQUE_ESPECIAL = "Conviertete En Chocolate";

    public static final double MAJINBOO_ESTADO_1_PODER_DE_PELEA = 30;
    public static final double MAJINBOO_ESTADO_1_DISTANCIA_DE_ATAQUE = 2;
    public static final double MAJINBOO_ESTADO_1_VELOCIDAD = 2;
    public static final double MAJINBOO_ESTADO_1_COSTO = 0;
    public static final int MAJINBOO_ESTADO_1_ID = 1;

    public static final double MAJINBOO_ESTADO_2_PODER_DE_PELEA = 50;
    public static final double MAJINBOO_ESTADO_2_DISTANCIA_DE_ATAQUE = 2;
    public static final double MAJINBOO_ESTADO_2_VELOCIDAD = 3;
    public static final double MAJINBOO_ESTADO_2_COSTO = 20;
    public static final int MAJINBOO_ESTADO_2_ID = 2;

    public static final double MAJINBOO_ESTADO_3_PODER_DE_PELEA = 60;
    public static final double MAJINBOO_ESTADO_3_DISTANCIA_DE_ATAQUE = 3;
    public static final double MAJINBOO_ESTADO_3_VELOCIDAD = 4;
    public static final double MAJINBOO_ESTADO_3_COSTO = 50;
    public static final int MAJINBOO_ESTADO_3_ID = 3;
    
    public MajinBoo() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAMajinBooEstado1();

        this.ki = MAJINBOO_CANTIDAD_KI_INICIAL;
        this.nombre = MAJINBOO_NOMBRE;
        this.vida = MAJINBOO_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = MAJINBOO_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = MAJINBOO_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = MAJINBOO_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = MAJINBOO_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
        this.turnosInutilizados = 0;
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
        if (!this.kiSuficiente(MAJINBOO_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(MAJINBOO_ESTADO_2_COSTO);
        this.estado.cambiarAMajinBooEstado2();
    }

    /*
     * Se cambia el Estado al de MajinBoo Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(MAJINBOO_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(MAJINBOO_ESTADO_3_COSTO);
        this.estado.cambiarAMajinBooEstado3();
    }

    /*
     * Determina si el personaje MajinBoo tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(MAJINBOO_KI_ATAQUE_ESPECIAL);
    }
    
    public void consecuenciasAtaqueEspecial(Personaje pj2){
    	pj2.inutilizar(MAJINBOO_TURNOS_QUE_INUTILIZA_OPONENTE);
    	// falta chequear que un personaje este inutilizado!!!!
    	// esto se hara en OrganizadorJuego cuando se haga lo de los turnos, para la tercera entrega
    }
}

