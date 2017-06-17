package modelo.personajes;

import modelo.equipo.Equipo;

public class Goku extends Personaje {

    public static final double GOKU_CANTIDAD_KI_INICIAL = 0;
    public static final double GOKU_CANTIDAD_VIDA_INICIAL = 500;
    public static final double GOKU_KI_ATAQUE_ESPECIAL = 20;
    public static final double GOKU_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL = 0.5;
    public static final double GOKU_PORCENTAJE_AUMENTO_ATAQUE_PASIVA = 0.2;
    public static final double GOKU_PORCENTAJE_VIDA_PARA_AUMENTO_ATAQUE_PASIVA = 0.3;
    public static final String GOKU_NOMBRE = "Goku";
    public static final String GOKU_NOMBRE_ATAQUE_ESPECIAL = "Kamehameha";

    public static final double GOKU_ESTADO_1_PODER_DE_PELEA = 20;
    public static final double GOKU_ESTADO_1_DISTANCIA_DE_ATAQUE = 2;
    public static final double GOKU_ESTADO_1_VELOCIDAD = 2;
    public static final double GOKU_ESTADO_1_COSTO = 0;
    public static final int GOKU_ESTADO_1_ID = 1;

    public static final double GOKU_ESTADO_2_PODER_DE_PELEA = 40;
    public static final double GOKU_ESTADO_2_DISTANCIA_DE_ATAQUE = 4;
    public static final double GOKU_ESTADO_2_VELOCIDAD = 3;
    public static final double GOKU_ESTADO_2_COSTO = 20;
    public static final int GOKU_ESTADO_2_ID = 2;

    public static final double GOKU_ESTADO_3_PODER_DE_PELEA = 60;
    public static final double GOKU_ESTADO_3_DISTANCIA_DE_ATAQUE = 4;
    public static final double GOKU_ESTADO_3_VELOCIDAD = 5;
    public static final double GOKU_ESTADO_3_COSTO = 50;
    public static final int GOKU_ESTADO_3_ID = 3;
    
    public Goku(String nombreEquipo) {
    	super(nombreEquipo);
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAGokuEstado1();

        this.ki = GOKU_CANTIDAD_KI_INICIAL;
        this.nombre = GOKU_NOMBRE;
        this.vida = GOKU_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = GOKU_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = GOKU_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = GOKU_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = GOKU_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
        
    }


    /*
     * Envia un mensaje al Estado actual, para cambiar sus atributos a los de Goku Estado 1.
     * La transformacion no comsume Ki, por lo tanto, no se verifica ni se lanza excepcion
     *
     */
    public void cambiarAEstado1() {
        this.estado.cambiarAGokuEstado1();
    }

    /*
     * Envia mensaje al Estado actual, para cambiar atributos a los de Goku Estado 2.
     * En esta transformacion se requiere un cierto nivel de Ki. Si no lo cumple, lanza excepcion.
     * Nota: El personaje Goku conoce el nivel de Ki requerido, y no el Estado. Es por eso que
     * se verifica la cantidad requirida de Ki para la transformacion en esta clase. No en Estado.
     */
    public void cambiarAEstado2() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(GOKU_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(GOKU_ESTADO_2_COSTO);
        this.estado.cambiarAGokuEstado2();
    }

    /*
     * Se cambia el Estado al de Goku Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(GOKU_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(GOKU_ESTADO_3_COSTO);
        this.estado.cambiarAGokuEstado3();
    }

    /*
     * Determina si el personaje Goku tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(GOKU_KI_ATAQUE_ESPECIAL);
    }
    
    public double getAumentoPasiva() {
    	if (this.vida < (GOKU_CANTIDAD_VIDA_INICIAL * GOKU_PORCENTAJE_VIDA_PARA_AUMENTO_ATAQUE_PASIVA))
    		return this.aumentoAtaquePasiva;
    	
    	return 0;
    }
    
    public void consecuenciasAtaqueEspecial(Personaje pj2){}
}
