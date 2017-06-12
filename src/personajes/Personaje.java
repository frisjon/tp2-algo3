package personajes;

import tablero.Casillero;
import tablero.ObjetoJuego;
import consumibles.Consumible;

public abstract class Personaje implements ObjetoJuego {

    protected double ki;
    protected double vida;    
    protected double kiAtaqueEspecial;
    protected double aumentoAtaqueEspecial;
    protected double aumentoAtaquePasiva;
    protected String nombre;
    protected String ataqueEspecial;
    protected Casillero casillero;
    protected Consumible consumible;
    protected EstadoPersonaje estado;
    protected int turnosInutilizados;
    
        
    public String getNombre() {
        return this.nombre;
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public double getKi() {
        return this.ki;
    }
    
    public void agregarKi(double _ki)
    {
        if (_ki < 0) return;
        this.ki += _ki;
    }
    
    public void quitarKi(double _ki)
    {
        if (_ki < 0) return;
        this.ki -= _ki;
    }
    
    public void agregarVida(double _vida)
    {
        if (_vida < 0) return;
        this.vida += _vida;
    }
    
    public void quitarVida(double _vida)
    {
        if (_vida < 0) return;
        this.vida -= _vida;
    }
    
    public String getAtaqueEspecial() {
        return this.ataqueEspecial;
    }
    
    public double getPoderPelea() {
        return this.estado.getPoderPelea();
    }
    
    public double getDistanciaAtaque() {
        return this.estado.getDistanciaAtaque();
    }
    
    public double getVelocidad() {
        return this.estado.getVelocidad();
    }
    
    /*
     * Determina si hay suficiente Ki
     * Devuelve true, si el Ki actual es mayor o igual al pedido.
     * Devuelve false, en otro caso.
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
    
    public boolean tieneConsumible() {
        if (this.consumible == null) return false;
        return true;
    }

    public Consumible getConsumible() {
        return this.consumible;
    }
    
    public void setConsumible(Consumible _consumible) {
        this.consumible = _consumible; 
    }

    public void eliminarConsumible() {
        this.consumible = null;
    }
    
    public double getAumentoPasiva() {
        return this.aumentoAtaquePasiva;
    }
    
    public double getKiNecesario() {
        return this.kiAtaqueEspecial;
    } 
    
    public double getAumentoAtaqueEspecial() {
        return this.aumentoAtaqueEspecial;
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
    
    public abstract void consecuenciasAtaqueEspecial(Personaje pj2);
    
    public void inutilizar(int cantidadTurnos){
    	this.turnosInutilizados += cantidadTurnos;
    }
    
    public int getTurnosInutilizados(){
    	return this.turnosInutilizados;
    }    
}
