package personajes;

public class Cell extends Personaje {
	
    private int cantidadAbsorciones;
    
    public Cell() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarACellEstado1();

        this.ki = ConstantesPersonajes.CELL_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesPersonajes.CELL_NOMBRE;
        this.vida = ConstantesPersonajes.CELL_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesPersonajes.CELL_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesPersonajes.CELL_KI_ATAQUE_ESPECIAL;
        this.cantidadAbsorciones = 0;
        this.aumentoAtaquePasiva = ConstantesPersonajes.CELL_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = ConstantesPersonajes.CELL_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
        this.turnosInutilizados = 0;
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
        if (!(ConstantesPersonajes.CELL_ESTADO_2_COSTO <= this.cantidadAbsorciones))
            throw new ErrorNoPuedeCambiarEstado(ConstantesPersonajes.CELL_MENSAJE_ABSORCIONES_INSUFICIENTES);
        this.estado.cambiarACellEstado2();
    }

    /*
     * Se cambia el Estado al de Cell Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!(ConstantesPersonajes.CELL_ESTADO_3_COSTO <= this.cantidadAbsorciones))
            throw new ErrorNoPuedeCambiarEstado(ConstantesPersonajes.CELL_MENSAJE_ABSORCIONES_INSUFICIENTES);
        this.estado.cambiarACellEstado3();
    }
    
    private void aumentarCantidadAbsorciones() {
    	this.cantidadAbsorciones += 1;
    }
    
    private void aumentarVida() {
    	this.vida += this.estado.poderPelea;
    	if (this.vida > 500)
    		this.vida = 500;
    }

    /*
     * Determina si el personaje Cell tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesPersonajes.CELL_KI_ATAQUE_ESPECIAL);
    }
    
    public void consecuenciasAtaqueEspecial(Personaje pj2){
    	this.aumentarCantidadAbsorciones();
    	this.aumentarVida();
    }
}
