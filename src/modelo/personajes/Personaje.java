package modelo.personajes;

import java.util.ArrayList;
import java.util.List;

import modelo.tablero.Casillero;
import modelo.tablero.ObjetoJuego;

public abstract class Personaje implements ObjetoJuego {

    protected double ki;
    protected double vida;
    protected double vidaInicial;
    protected double kiAtaqueEspecial;
    protected double aumentoAtaqueEspecial;
    protected double aumentoAtaquePasiva;
    protected String nombre;
    protected String ataqueEspecial;
    protected Casillero casillero;
    protected List<ObjetoJuego> objetos; // para que sea mas generico, no hay que limitarlo a una cosa
    									 // por si el dia de mañana quiero meter otra cosa
    protected EstadoPersonaje estado;
    protected int turnosInutilizados;
    protected String nombreEquipo;
    
    public Personaje(String nombreEquipo){
    	this.nombreEquipo = nombreEquipo;
    	this.objetos = new ArrayList<ObjetoJuego>();
    	this.turnosInutilizados = 0;    	
    }
    
    public String getNombreEquipo(){
    	return this.nombreEquipo;    	
    }
        
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
        if (this.vida > this.vidaInicial)
        	this.vida = this.vidaInicial;
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
    
    public boolean equals(Personaje personaje){
        return this.getClass().equals(personaje.getClass());
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
    
    public boolean tieneObjeto() {
        if (this.objetos.size() == 0) return false;
        return true;
    }

    public List<ObjetoJuego> getObjetos() {
        return this.objetos;
    }
    
    public void setObjeto(ObjetoJuego objeto) {
        this.objetos.add(objeto); 
    }

    public void eliminarObjeto(ObjetoJuego objeto) {
        this.objetos.remove(objeto);
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
    
    public boolean sePuedePasar(){
    	return false;
    }
    
    public boolean sePuedeObtener(){
    	return false;
    }
    
    public void obtenerObjeto(ObjetoJuego objeto){
    	this.objetos.add(objeto);
    }
    
    public String getAtributo() throws ErrorNoCompatibilidad {
    	throw new ErrorNoCompatibilidad("Método no compatible");
    }
    
    public void decrementarUso() throws ErrorNoCompatibilidad {
    	throw new ErrorNoCompatibilidad("Método no compatible");
    }
    
    public int getCantidadUsosRestantes() throws ErrorNoCompatibilidad {
    	throw new ErrorNoCompatibilidad("Método no compatible");
    }
    
    public double getCantidadAtributo() throws ErrorNoCompatibilidad {
    	throw new ErrorNoCompatibilidad("Método no compatible");
    }
    
    public void decrementarTurno() throws ErrorNoCompatibilidad {
    	throw new ErrorNoCompatibilidad("Método no compatible");
    }
    
    public int getCantidadTurnosRestantes() throws ErrorNoCompatibilidad {
    	throw new ErrorNoCompatibilidad("Método no compatible");
    }
	
}
