package personajes;

import personajes.ConstantesPiccolo;
import personajes.Personaje;
import motor.ErrorNoHayKi;
import personajes.EstadoPersonaje;

public class Piccolo extends Personaje {
	
    private Personaje protegido;
    private double vidaInicialProtegido;
    
    public Piccolo() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAPiccoloEstado1();

        this.ki = ConstantesPiccolo.PICCOLO_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesPiccolo.PICCOLO_NOMBRE;
        this.vida = ConstantesPiccolo.PICCOLO_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesPiccolo.PICCOLO_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesPiccolo.PICCOLO_KI_ATAQUE_ESPECIAL;
        
        this.protegido = null;
        this.vidaInicialProtegido = 0;
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
    public void cambiarAEstado2() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        if (!this.kiSuficiente(ConstantesPiccolo.PICCOLO_ESTADO_2_COSTO))
            throw new ErrorCambiarEstadoCondicionesNoCumplidas("Ki insuficiente.");
        this.quitarKi(ConstantesPiccolo.PICCOLO_ESTADO_2_COSTO);
        this.estado.cambiarAPiccoloEstado2();
    }

    /*
     * Se cambia el Estado al de Piccolo Estado 3
     */
    public void cambiarAEstado3() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        if (!this.kiSuficiente(ConstantesPiccolo.PICCOLO_ESTADO_3_COSTO))
            throw new ErrorCambiarEstadoCondicionesNoCumplidas("Ki insuficiente.");
        if (!(this.vidaInicialProtegido * ConstantesPiccolo.PICCOLO_PORCENTAJE_VIDA_PROTEGIDO <= this.vidaInicialProtegido))
        	throw new ErrorCambiarEstadoCondicionesNoCumplidas(ConstantesPiccolo.PICCOLO_PROTEGIDO_SANO);
        this.quitarKi(ConstantesPiccolo.PICCOLO_ESTADO_3_COSTO);
        this.estado.cambiarAPiccoloEstado3();
    }

    /*
     * Determina si el personaje Piccolo tiene Ki suficiente para realizar el ataque especial.
     */
    @Override
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesPiccolo.PICCOLO_KI_ATAQUE_ESPECIAL);
    }
}
