package personajes;

public class Gohan extends Personaje {

    private Personaje aliado1;
    private Personaje aliado2;
    private double vidaInicialAliado1;
    private double vidaInicialAliado2;
    
    public Gohan() {
        this.estado = new EstadoPersonaje();
        this.estado.cambiarAGohanEstado1();

        this.ki = ConstantesPersonajes.GOHAN_CANTIDAD_KI_INICIAL;
        this.nombre = ConstantesPersonajes.GOHAN_NOMBRE;
        this.vida = ConstantesPersonajes.GOHAN_CANTIDAD_VIDA_INICIAL;
        this.ataqueEspecial = ConstantesPersonajes.GOHAN_NOMBRE_ATAQUE_ESPECIAL;
        this.kiAtaqueEspecial = ConstantesPersonajes.GOHAN_KI_ATAQUE_ESPECIAL;
        this.aumentoAtaquePasiva = ConstantesPersonajes.GOHAN_PORCENTAJE_AUMENTO_ATAQUE_PASIVA;
        this.aumentoAtaqueEspecial = ConstantesPersonajes.GOHAN_PORCENTAJE_AUMENTO_ATAQUE_ESPECIAL;
        
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
        if (!this.kiSuficiente(ConstantesPersonajes.GOHAN_ESTADO_2_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        this.quitarKi(ConstantesPersonajes.GOHAN_ESTADO_2_COSTO);
        this.estado.cambiarAGohanEstado2();
    }

    /*
     * Se cambia el Estado al de Gohan Estado 3
     */
    public void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado {
        if (!this.kiSuficiente(ConstantesPersonajes.GOHAN_ESTADO_3_COSTO))
            throw new ErrorNoPuedeCambiarEstado("Ki insuficiente.");
        if (this.aliado1 == null || this.aliado2 == null)
            throw new ErrorNoPuedeCambiarEstado(ConstantesPersonajes.GOHAN_MENSAJE_ALIADO_INVALIDO);
        if (!((this.aliado1.getVida() < this.vidaInicialAliado1 * ConstantesPersonajes.GOHAN_PORCENTAJE_VIDA_ALIADO_1) &&
              (this.aliado2.getVida() < this.vidaInicialAliado2 * ConstantesPersonajes.GOHAN_PORCENTAJE_VIDA_ALIADO_2) ))
            throw new ErrorNoPuedeCambiarEstado(ConstantesPersonajes.GOHAN_MENSAJE_ALIADOS_SANOS);
        this.quitarKi(ConstantesPersonajes.GOHAN_ESTADO_3_COSTO);
        this.estado.cambiarAGohanEstado3();
    }

    /*
     * Determina si el personaje Gohan tiene Ki suficiente para realizar el ataque especial.
     */
    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(ConstantesPersonajes.GOHAN_KI_ATAQUE_ESPECIAL);
    }
    
    public void consecuenciasAtaqueEspecial(){}
}
