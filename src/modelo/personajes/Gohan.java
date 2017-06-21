package modelo.personajes;

public class Gohan extends Personaje {

    public static final double GOHAN_CANTIDAD_KI_INICIAL = 0;
    public static final double GOHAN_CANTIDAD_VIDA_INICIAL = 300;
    public static final double GOHAN_KI_ATAQUE_ESPECIAL = 10;
    public static final double GOHAN_PORCENTAJE_VIDA_ALIADO_1 = 0.3;
    public static final double GOHAN_PORCENTAJE_VIDA_ALIADO_2 = 0.3;
    public static final double GOHAN_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL = 0.25;
    public static final double GOHAN_PORCENTAJE_AUMENTO_ATAQUE_PASIVA = 0;
    public static final String GOHAN_NOMBRE = "Gohan";
    public static final String GOHAN_NOMBRE_ATAQUE_ESPECIAL = "Masenko";
    public static final String GOHAN_MENSAJE_ALIADOS_SANOS = "Aliados sanos.";
    public static final String GOHAN_MENSAJE_ALIADO_INVALIDO = "Aliado Invalido";
    public static final String GOHAN_NOMBRE_PRIMERA_TRANSFORMACION = "Super Sayajin fase 1";
    public static final String GOHAN_NOMBRE_SEGUNDA_TRANSFORMACION = "Super Sayajin fase 2";

    public static final double GOHAN_ESTADO_1_PODER_DE_PELEA = 15;
    public static final double GOHAN_ESTADO_1_DISTANCIA_DE_ATAQUE = 2;
    public static final double GOHAN_ESTADO_1_VELOCIDAD = 2;
    public static final double GOHAN_ESTADO_1_COSTO = 0;
    public static final int GOHAN_ESTADO_1_ID = 1;

    public static final double GOHAN_ESTADO_2_PODER_DE_PELEA = 30;
    public static final double GOHAN_ESTADO_2_DISTANCIA_DE_ATAQUE = 2;
    public static final double GOHAN_ESTADO_2_VELOCIDAD = 2;
    public static final double GOHAN_ESTADO_2_COSTO = 10;
    public static final int GOHAN_ESTADO_2_ID = 2;

    public static final double GOHAN_ESTADO_3_PODER_DE_PELEA = 100;
    public static final double GOHAN_ESTADO_3_DISTANCIA_DE_ATAQUE = 4;
    public static final double GOHAN_ESTADO_3_VELOCIDAD = 3;
    public static final double GOHAN_ESTADO_3_COSTO = 30;
    public static final int GOHAN_ESTADO_3_ID = 3;
    
    private Personaje aliado1;
    private Personaje aliado2;
    private double vidaInicialAliado1;
    private double vidaInicialAliado2;
    
    public Gohan(String nombreEquipo) {
    	super(nombreEquipo);
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAGohanEstado1();

        this.ki = GOHAN_CANTIDAD_KI_INICIAL;
        this.nombre = GOHAN_NOMBRE;
        this.vidaInicial = GOHAN_CANTIDAD_VIDA_INICIAL;
        this.vida = this.vidaInicial;
        this.ataqueEspecial = GOHAN_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = GOHAN_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = GOHAN_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = GOHAN_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
        this.nombrePrimeraTransformacion = GOHAN_NOMBRE_PRIMERA_TRANSFORMACION;
        this.nombreSegundaTransformacion = GOHAN_NOMBRE_SEGUNDA_TRANSFORMACION;
        
        this.aliado1 = null;
        this.vidaInicialAliado1 = 0;
        this.aliado2 = null;
        this.vidaInicialAliado2 = 0;
        
        
    }

    
    public void setAliado1(Personaje _aliado1) {
        this.aliado1 = _aliado1;
        this.vidaInicialAliado1 = this.aliado1.getVida();
    }

    public void setAliado2(Personaje _aliado2) {
        this.aliado2 = _aliado2;
        this.vidaInicialAliado2 = this.aliado2.getVida();
    }
    
    /*
     * Envia un mensaje al Estado actual, para cambiar sus atributos a los de Gohan Estado 1.
     * La transformacion no comsume Ki, por lo tanto, no se verifica ni se lanza excepcion
     *
     */
    public void cambiarAEstado1() {
        this.estado.cambiarAGohanEstado1();
    }

    /*
     * Envia mensaje al Estado actual, para cambiar atributos a los de Gohan Estado 2.
     * En esta transformacion se requiere un cierto nivel de Ki. Si no lo cumple, lanza excepcion.
     * Nota: El personaje Gohan conoce el nivel de Ki requerido, y no el Estado. Es por eso que
     * se verifica la cantidad requirida de Ki para la transformacion en esta clase. No en Estado.
     */
    public void cambiarAEstado2() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(GOHAN_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(GOHAN_ESTADO_2_COSTO);
        this.estado.cambiarAGohanEstado2();
    }

    /*
     * Se cambia el Estado al de Gohan Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(GOHAN_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        if (this.aliado1 == null || this.aliado2 == null)
            throw new ErrorNoPuedeCambiarEstado(GOHAN_MENSAJE_ALIADO_INVALIDO);
        if (!((this.aliado1.getVida() < this.vidaInicialAliado1 * GOHAN_PORCENTAJE_VIDA_ALIADO_1) &&
              (this.aliado2.getVida() < this.vidaInicialAliado2 * GOHAN_PORCENTAJE_VIDA_ALIADO_2) ))
            throw new ErrorNoPuedeCambiarEstado(GOHAN_MENSAJE_ALIADOS_SANOS);
        this.quitarKi(GOHAN_ESTADO_3_COSTO);
        this.estado.cambiarAGohanEstado3();
    }

    /*
     * Determina si el personaje Gohan tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(GOHAN_KI_ATAQUE_ESPECIAL);
    }
    
    public void consecuenciasAtaqueEspecial(Personaje pj2){}
}
