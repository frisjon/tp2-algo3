package personajes;

public class Goku extends Personaje {

    public Goku() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAGokuEstado1();

        this.ki = ConstantesPersonajes.GOKU_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesPersonajes.GOKU_NOMBRE;
        this.vida = ConstantesPersonajes.GOKU_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesPersonajes.GOKU_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesPersonajes.GOKU_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = ConstantesPersonajes.GOKU_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = ConstantesPersonajes.GOKU_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
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
        if (!this.kiSuficiente(ConstantesPersonajes.GOKU_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesPersonajes.GOKU_ESTADO_2_COSTO);
        this.estado.cambiarAGokuEstado2();
    }

    /*
     * Se cambia el Estado al de Goku Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(ConstantesPersonajes.GOKU_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesPersonajes.GOKU_ESTADO_3_COSTO);
        this.estado.cambiarAGokuEstado3();
    }

    /*
     * Determina si el personaje Goku tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesPersonajes.GOKU_KI_ATAQUE_ESPECIAL);
    }
    
    public double getAumentoPasiva() {
    	if (this.vida < (ConstantesPersonajes.GOKU_CANTIDAD_VIDA_INICIAL * ConstantesPersonajes.GOKU_PORCENTAJE_VIDA_PARA_AUMENTO_ATAQUE_PASIVA))
    		return this.aumentoAtaquePasiva;
    	
    	return 0;
    }
    
    public void consecuenciasAtaqueEspecial(){}
}
