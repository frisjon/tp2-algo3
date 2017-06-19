package modelo.personajes;

public class Cell extends Personaje {
	
    public static final double CELL_CANTIDAD_KI_INICIAL = 0;
    public static final double CELL_CANTIDAD_VIDA_INICIAL = 500;
    public static final double CELL_KI_ATAQUE_ESPECIAL = 5;
    public static final double CELL_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL = 0;
    public static final double CELL_PORCENTAJE_AUMENTO_ATAQUE_PASIVA = 0;
    public static final String CELL_NOMBRE = "Cell";
    public static final String CELL_NOMBRE_ATAQUE_ESPECIAL = "Absorber";
    public static final String CELL_MENSAJE_ABSORCIONES_INSUFICIENTES = "Cantidad de absorciones insuficientes.";
    public static final String CELL_NOMBRE_PRIMERA_TRANSFORMACION = "Semi-perfecto";
    public static final String CELL_NOMBRE_SEGUNDA_TRANSFORMACION = "Perfecto";

    public static final double CELL_ESTADO_1_PODER_DE_PELEA = 20;
    public static final double CELL_ESTADO_1_DISTANCIA_DE_ATAQUE = 3;
    public static final double CELL_ESTADO_1_VELOCIDAD = 2;
    public static final double CELL_ESTADO_1_COSTO = 0;
    public static final int CELL_ESTADO_1_ID = 1;

    public static final double CELL_ESTADO_2_PODER_DE_PELEA = 40;
    public static final double CELL_ESTADO_2_DISTANCIA_DE_ATAQUE = 4;
    public static final double CELL_ESTADO_2_VELOCIDAD = 3;
    public static final double CELL_ESTADO_2_COSTO = 4;
    public static final int CELL_ESTADO_2_ID = 2;
    public static final int CELL_ESTADO_2_COSTO_ATAQUE_ESPECIAL = 4;

    public static final double CELL_ESTADO_3_PODER_DE_PELEA = 80;
    public static final double CELL_ESTADO_3_DISTANCIA_DE_ATAQUE = 4;
    public static final double CELL_ESTADO_3_VELOCIDAD = 4;
    public static final double CELL_ESTADO_3_COSTO = 8;
    public static final int CELL_ESTADO_3_ID = 3;
    public static final int CELL_ESTADO_3_COSTO_ATAQUE_ESPECIAL = 8;
    
    private int cantidadAbsorciones;
    
    public Cell(String nombreEquipo) {
    	super(nombreEquipo);
        this.estado = new EstadoPersonaje();
        this.estado.cambiarACellEstado1();

        this.ki = CELL_CANTIDAD_KI_INICIAL;
        this.nombre = CELL_NOMBRE;
        this.vidaInicial = CELL_CANTIDAD_VIDA_INICIAL;
        this.vida = this.vidaInicial;
        this.ataqueEspecial = CELL_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = CELL_KI_ATAQUE_ESPECIAL;
        this.cantidadAbsorciones = 0;
        this.aumentoAtaquePasiva = CELL_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = CELL_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
        this.nombrePrimeraTransformacion = CELL_NOMBRE_PRIMERA_TRANSFORMACION;
        this.nombreSegundaTransformacion = CELL_NOMBRE_SEGUNDA_TRANSFORMACION;
        
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
        if (!(CELL_ESTADO_2_COSTO <= this.cantidadAbsorciones))
            throw new ErrorNoPuedeCambiarEstado(CELL_MENSAJE_ABSORCIONES_INSUFICIENTES);
        this.estado.cambiarACellEstado2();
    }

    /*
     * Se cambia el Estado al de Cell Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!(CELL_ESTADO_3_COSTO <= this.cantidadAbsorciones))
            throw new ErrorNoPuedeCambiarEstado(CELL_MENSAJE_ABSORCIONES_INSUFICIENTES);
        this.estado.cambiarACellEstado3();
    }
    
    private void aumentarCantidadAbsorciones() {
    	this.cantidadAbsorciones += 1;
    }
    
    private void aumentarVida() {
    	this.vida += this.estado.poderPelea;
    	if (this.vida > this.vidaInicial)
    		this.vida = this.vidaInicial;
    }

    /*
     * Determina si el personaje Cell tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(CELL_KI_ATAQUE_ESPECIAL);
    }
    
    public void consecuenciasAtaqueEspecial(Personaje pj2){
    	this.aumentarCantidadAbsorciones();
    	this.aumentarVida();
    }
}
