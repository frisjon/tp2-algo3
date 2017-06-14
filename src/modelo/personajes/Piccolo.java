package modelo.personajes;

public class Piccolo extends Personaje {
	
    public static final double PICCOLO_CANTIDAD_KI_INICIAL = 0;
    public static final double PICCOLO_CANTIDAD_VIDA_INICIAL = 500;
    public static final double PICCOLO_KI_ATAQUE_ESPECIAL = 10;
    public static final double PICCOLO_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL = 0.25;
    public static final double PICCOLO_PORCENTAJE_AUMENTO_ATAQUE_PASIVA = 0;
    public static final double PICCOLO_PORCENTAJE_VIDA_PROTEGIDO = 0.2;
    public static final String PICCOLO_NOMBRE = "Piccolo";
    public static final String PICCOLO_NOMBRE_ATAQUE_ESPECIAL = "Makankosappo";
    public static final String PICCOLO_MENSAJE_PROTEGIDO_SANO = "Protegido sano.";
    public static final String PICCOLO_MENSAJE_PROTEGIDO_INVALIDO = "Protegido Invalido";

    public static final double PICCOLO_ESTADO_1_PODER_DE_PELEA = 20;
    public static final double PICCOLO_ESTADO_1_DISTANCIA_DE_ATAQUE = 2;
    public static final double PICCOLO_ESTADO_1_VELOCIDAD = 2;
    public static final double PICCOLO_ESTADO_1_COSTO = 0;
    public static final int PICCOLO_ESTADO_1_ID = 1;

    public static final double PICCOLO_ESTADO_2_PODER_DE_PELEA = 40;
    public static final double PICCOLO_ESTADO_2_DISTANCIA_DE_ATAQUE = 4;
    public static final double PICCOLO_ESTADO_2_VELOCIDAD = 3;
    public static final double PICCOLO_ESTADO_2_COSTO = 20;
    public static final int PICCOLO_ESTADO_2_ID = 2;

    public static final double PICCOLO_ESTADO_3_PODER_DE_PELEA = 60;
    public static final double PICCOLO_ESTADO_3_DISTANCIA_DE_ATAQUE = 6;
    public static final double PICCOLO_ESTADO_3_VELOCIDAD = 4;
    public static final double PICCOLO_ESTADO_3_COSTO = 0;
    public static final int PICCOLO_ESTADO_3_ID = 3;
    
    private Personaje protegido;
    private double vidaInicialProtegido;
    
    public Piccolo() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAPiccoloEstado1();

        this.ki = PICCOLO_CANTIDAD_KI_INICIAL;
        this.nombre = PICCOLO_NOMBRE;
        this.vida = PICCOLO_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = PICCOLO_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = PICCOLO_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = PICCOLO_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = PICCOLO_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
        
        this.protegido = null;
        this.vidaInicialProtegido = 0;
        
        this.turnosInutilizados = 0;
    }
    
    
    public void setProtegido(Personaje _protegido) {
        this.protegido = _protegido;
        this.vidaInicialProtegido = this.protegido.getVida();
    }

    /*
     * Envia un mensaje al Estado actual, para cambiar sus atributos a los de Piccolo Estado 1.
     * La transformacion no comsume Ki, por lo tanto, no se verifica ni se lanza excepcion
     *
     */
    public void cambiarAEstado1() {
        this.estado.cambiarAPiccoloEstado1();
    }

    /*
     * Envia mensaje al Estado actual, para cambiar atributos a los de Piccolo Estado 2.
     * En esta transformacion se requiere un cierto nivel de Ki. Si no lo cumple, lanza excepcion.
     * Nota: El personaje Piccolo conoce el nivel de Ki requerido, y no el Estado. Es por eso que
     * se verifica la cantidad requirida de Ki para la transformacion en esta clase. No en Estado.
     */
    public void cambiarAEstado2() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(PICCOLO_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(PICCOLO_ESTADO_2_COSTO);
        this.estado.cambiarAPiccoloEstado2();
    }

    /*
     * Se cambia el Estado al de Piccolo Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(PICCOLO_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        if (this.protegido == null)
            throw new ErrorNoPuedeCambiarEstado(PICCOLO_MENSAJE_PROTEGIDO_INVALIDO);
        if (!(this.protegido.getVida() < this.vidaInicialProtegido * PICCOLO_PORCENTAJE_VIDA_PROTEGIDO))
        	throw new ErrorNoPuedeCambiarEstado(PICCOLO_MENSAJE_PROTEGIDO_SANO);
        this.quitarKi(PICCOLO_ESTADO_3_COSTO);
        this.estado.cambiarAPiccoloEstado3();
    }

    /*
     * Determina si el personaje Piccolo tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(PICCOLO_KI_ATAQUE_ESPECIAL);
    }
    
    public void consecuenciasAtaqueEspecial(Personaje pj2){}
}
