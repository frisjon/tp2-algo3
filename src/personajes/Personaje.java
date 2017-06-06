package personajes;


import tablero.Casillero;
import tablero.ObjetoJuego;


public abstract class Personaje implements ObjetoJuego {
    
    protected String nombre;
    protected double vida;
    protected double ki;
    protected EstadoPersonaje estado;
    protected String ataqueEspecial;
    protected Casillero casillero;
    public static final String KI_INSUFICIENTE = "Ki Insuficiente"; 

    
    public String getNombre() {
        return this.nombre;
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public double getKi() {
        return this.ki;
    }
    
    public void agregarKi(double _ki) //throw ErrorValorNegativo
    {
        if (_ki < 0) return; //throw ErrorValorNegativo;
        this.ki += _ki;
    }
    
    public void quitarKi(double _ki) //throw ErrorValorNegativo
    {
        if (_ki < 0) return; //throw ErrorValorNegativo;
        this.ki -= _ki;
    }
    
    public void agregarVida(double _vida) //throw ErrorValorNegativo
    {
        if (_vida < 0) return; //throw ErrorValorNegativo;
        this.vida += _vida;
    }
    
    public void quitarVida(double _vida) //throw ErrorValorNegativo
    {
        if (_vida < 0) return; //throw ErrorValorNegativo;
        this.vida -= _vida;
    }
    
    public String getAtaqueEspecial() {
        return this.ataqueEspecial;
    }
    
    public double getPoderDePelea() {
        return this.estado.getPoderDePelea();
    }
    
    public double getDistanciaAtaque() {
        return this.estado.getDistanciaAtaque();
    }
    
    public double getVelocidad() {
        return this.estado.getVelocidad();
    }
    
    /*
     * Determina si hay suficiente Ki
     * Devuelve true, si el Ki actual es mayor o igual al pedido
     * Devuelve false, en otro caso
     * 
     */
    public boolean kiSuficiente(double _ki) {
        if (_ki <= this.ki) return true;
        return false;
    }
    
    public void setCasillero(Casillero _casillero) {
        this.casillero = _casillero;
    }
    
    public Casillero getCasillero() {
        return this.casillero;
    }
    
    public int getIdEstado() {
        return this.estado.getIdEstado();
    }
    
    /*
     * Metodos Abstractos
     */
    
    /*
     * Cambiar Estado
     * (es lo mismo que el personaje se transforme)
     */
    //public abstract void cambiarEstado(int idEstado);
    public abstract void cambiarAEstado1();
    public abstract void cambiarAEstado2() throws ErrorNoPuedeCambiarEstado;
    public abstract void cambiarAEstado3() throws ErrorNoPuedeCambiarEstado;
    //public abstract void cambiarAEstado4();
    
    /*
     * Devuelve true, si se cumplen las condiciones necesarias para realizar el ataque especial.
     * (Depende del personaje, por eso es un metodo abstracto)
     */
    public abstract boolean puedeRealizarAtaqueEspecial();
    
    
}
