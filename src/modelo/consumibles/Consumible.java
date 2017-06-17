package modelo.consumibles;

import java.util.List;

import modelo.personajes.ErrorNoCompatibilidad;
import modelo.tablero.Casillero;
import modelo.tablero.ObjetoJuego;


/**
 * Clase abstracta que representa un Consumible del juego.
 * 
 * @author Thomas
 */
public abstract class Consumible implements ObjetoJuego {
    protected String nombre;
    protected String atributo;
    /**
     * cantidadAtributo es double porque toma en cuenta los casos en los cuales debe incrementar porcentajes o 
     * incrementar por un cociente.
     */
    protected double cantidadAtributo;
    /**
     * Si instantaneo es true, la cantidad de turnos restantes no sera tenida en cuenta.
     */
    protected boolean instantaneo;
    protected int cantidadUsosRestantes;
    protected int cantidadTurnosRestantes;
    protected Casillero casillero;
    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getAtributo(){
        return this.atributo;
    }
    
    public double getCantidadAtributo(){
        return this.cantidadAtributo;
    }
    
    public boolean getInstantaneo(){
        return this.instantaneo;
    }
    
    public Casillero getCasillero(){
        return this.casillero;
    }
    
    public void setCasillero(Casillero casillero){
    	this.casillero = casillero;
    }
    
    public boolean sePuedePasar(){
    	return true;
    }
    
    public boolean sePuedeObtener(){
    	return true;
    }
    
    public boolean tieneObjeto(){
    	return false;
    }
    
    public List<ObjetoJuego> getObjetos() throws ErrorNoCompatibilidad {
    	throw new ErrorNoCompatibilidad("Método no compatible");
    }
    
    public void eliminarObjeto(ObjetoJuego objeto) throws ErrorNoCompatibilidad {
    	throw new ErrorNoCompatibilidad("Método no compatible");
    }
}
